package Carts;

import Products.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CartTests {

    CartCommand cartCommand = new CartCommand();
    SetCart cart;

    @Before
    public void before() {
        cart = new SetCart();
    }

    @Test
    public void test_adding_to_cart() {
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(10, "test", "test_item")));
        cartCommand.executeCommand();
        String result = cart.toString();
        assertEquals("add item to cart", "name: test_item, price: 10\n", result);
    }

    @Test
    public void test_adding_to_cart_multiple_times() {
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(10, "test", "test_item")));
        cartCommand.executeCommand();
        cartCommand.executeCommand();
        cartCommand.executeCommand();
        cartCommand.executeCommand();
        int productsAmount = cart.getProductList().getList().length;
        assertEquals("add items to cart multiple times", 4, productsAmount);
    }

    @Test
    public void test_deleting_from_cart() {
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(10, "test", "test_item")));
        cartCommand.executeCommand();
        cartCommand.setCommand(new SetCartDeleteProductCommand(cart, new Product(10, "test", "test_item")));
        cartCommand.executeCommand();
        String result = cart.toString();
        assertEquals("delete item from cart", "", result);
    }

    @Test
    public void test_deleting_from_cart_multiple_times() {
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(10, "test", "test_item")));
        cartCommand.executeCommand();
        cartCommand.executeCommand();
        cartCommand.executeCommand();
        cartCommand.executeCommand();
        cartCommand.setCommand(new SetCartDeleteProductCommand(cart, new Product(10, "test", "test_item")));
        cartCommand.executeCommand();
        cartCommand.executeCommand();
        int productsAmount = cart.getProductList().getList().length;
        assertEquals("delete items from cart multiple times", 2, productsAmount);
    }

    @Test
    public void test_calulating_cart_value() {
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(10, "test", "test_item")));
        cartCommand.executeCommand();
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(30, "test2", "test_item2")));
        cartCommand.executeCommand();
        double result = cart.calculateCost();
        assertEquals("calculating cart value", 40, result, 0.0001);
    }
}
