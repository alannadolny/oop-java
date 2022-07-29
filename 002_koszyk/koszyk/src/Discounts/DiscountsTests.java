package Discounts;

import Carts.SetCart;
import Carts.SetCartAddProductCommand;
import Products.*;
import Carts.*;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class DiscountsTests {
    CartCommand cartCommand = new CartCommand();
    SetCart cart;

    @Before
    public void before() {
        cart = new SetCart();
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(150, "test", "test_item")));
        cartCommand.executeCommand();
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(250, "test2", "test_item2")));
        cartCommand.executeCommand();
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(80, "test3", "test_item3")));
        cartCommand.executeCommand();
    }

    @Test
    public void test_discount_if_order_more_expensive_than_300() {
        SetDiscountCommand discountCommand = new SetDiscountCommand(cart, new DiscountIfOrderMoreExpensiveThan300("300"));
        discountCommand.execute();
        double result = cart.calculateCost();
        assertEquals("discount if order more expensive than 300", 456, result, 0.0001);
    }

    @Test
    public void test_discount_if_order_more_expensive_than_200() {
        SetDiscountCommand discountCommand = new SetDiscountCommand(cart, new DiscountIfOrderMoreExpensiveThan200("200"));
        discountCommand.execute();
        String result = cart.toString();
        int giftListLength = cart.getGiftsListLength();
        assertEquals("discount if order more expensive than 200",
                """
                        name: test_item, price: 150
                        name: test_item2, price: 250
                        name: test_item3, price: 80
                        """, result);
        assertEquals("test if gift are added", 1, giftListLength);
    }

    @Test
    public void test_discount_if_buy_3_products() {
        SetDiscountCommand discountCommand = new SetDiscountCommand(cart, new DiscountIfBuy3Products("third_free"));
        discountCommand.execute();
        double result = cart.calculateCost();
        assertEquals("discount if buy 3 products", 400, result, 0.0001);
    }

    @Test
    public void test_discount_for_specific_product() {
        SetDiscountCommand discountCommand = new SetDiscountCommand(cart, new DiscountForSpecificProduct("test2", "discount"));
        discountCommand.execute();
        double result = cart.calculateCost();
        assertEquals("discount if buy 3 products", 405, result, 0.0001);
    }

    @Test
    public void test_add_discount_later() {
        SetDiscounts discounts = new SetDiscounts.Builder().build();
        discounts.addDiscount(new DiscountForSpecificProduct("test2", "discount"));
        for(int i = 0; i < discounts.getDiscountsAmount(); i++) {
            SetDiscountCommand discountCommand = new SetDiscountCommand(cart, discounts.getDiscounts().get(i));
            discountCommand.execute();
        }
        double result = cart.calculateCost();
        assertEquals("test adding discount later", 405, result, 0.0001);
    }

    @Test
    public void test_remove_discount() {
        SetDiscounts discounts = new SetDiscounts.Builder()
                .addDiscount(new DiscountForSpecificProduct("test2", "discount"))
                .addDiscount(new DiscountIfBuy3Products("third_free")).build();
        discounts.removeDiscount("third_free");
        for(int i = 0; i < discounts.getDiscountsAmount(); i++) {
            SetDiscountCommand discountCommand = new SetDiscountCommand(cart, discounts.getDiscounts().get(i));
            discountCommand.execute();
        }
        double result = cart.calculateCost();
        assertEquals("test removing discount", 405, result, 0.0001);
    }

}
