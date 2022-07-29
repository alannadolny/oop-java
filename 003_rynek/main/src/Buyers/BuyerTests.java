package Buyers;

import CentralBank.Bank;
import Products.Product;
import Sellers.Seller;
import Sellers.Visitor;
import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyerTests {

    Bank bank;
    Seller seller;
    Buyer buyer;

    @Before
    public void setUp() {
        bank = new Bank();
        Product firstProduct = new Product("chocolate", 3, 1.2F, 2.3F);
        Product secondProduct = new Product("cookies", 3, 2F, 2.3F);
        ArrayList<Product> toSell = new ArrayList<>();
        toSell.add(firstProduct);
        toSell.add(secondProduct);
        seller = new Seller(toSell);
        bank.attach(seller);
        bank.setInflation(5);
        bank.notifyUpdate();
        seller.attach(bank);
        seller.accept(new Visitor());
    }

    @Test
    public void test_buy_one_product_when_current_price_is_lower_than_expected() {
        HashMap<String, Float> toBuy = new HashMap<>() {{
            put("chocolate", 7F);
        }};
        buyer = new Buyer(toBuy);
        seller.attach(buyer);
        seller.notifyUpdate();
        assertEquals("test buy one product", toBuy.size(), 0);
    }

    @Test
    public void test_buy_few_products_when_current_price_is_lower_than_expected() {
        HashMap<String, Float> toBuy = new HashMap<>() {{
            put("chocolate", 7F);
            put("cookies", 7F);
        }};
        buyer = new Buyer(toBuy);
        seller.attach(buyer);
        seller.notifyUpdate();
        assertEquals("test buy few products", toBuy.size(), 0);
    }

    @Test
    public void test_buy_product_when_current_price_is_higher_than_expected() {
        HashMap<String, Float> toBuy = new HashMap<>() {{
            put("chocolate", 7F);
        }};
        buyer = new Buyer(toBuy) {
            public boolean tryToBuy(Product product) {
                return false;
            }
        };
        seller.attach(buyer);
        seller.notifyUpdate();
        assertEquals("test buy product", toBuy.size(), 1);
    }

    @Test
    public void test_buy_few_products_when_current_price_is_higher_than_expected() {
        HashMap<String, Float> toBuy = new HashMap<>() {{
            put("chocolate", 7F);
            put("cookies", 7F);
        }};
        buyer = new Buyer(toBuy) {
            public boolean tryToBuy(Product product) {
                return false;
            }
        };
        seller.attach(buyer);
        seller.notifyUpdate();
        assertEquals("test buy product", toBuy.size(), 2);
    }

    @Test
    public void test_buy_if_seller_doesnt_have_product() {
        HashMap<String, Float> toBuy = new HashMap<>() {{
            put("apple", 7F);
            put("milk", 7F);
        }};
        buyer = new Buyer(toBuy);
        seller.attach(buyer);
        seller.notifyUpdate();
        assertEquals("test buy if sellers doesnt have products", toBuy.size(), 2);
    }
}
