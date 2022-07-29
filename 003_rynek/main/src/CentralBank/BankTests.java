package CentralBank;

import Buyers.Buyer;
import Products.Product;
import Sellers.Seller;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;

public class BankTests {

    Bank bank;
    Seller seller;
    Buyer buyer;
    HashMap<String, Float> toBuy;
    @Before
    public void setUp() {
        bank = new Bank();
        bank.setInflation(5);
        toBuy = new HashMap<>(){{
            put("chocolate", 7F);
            put("cookies", 7F);
        }};
        Product firstProduct = new Product("chocolate", 3, 1.2F, 2.3F);
        Product secondProduct = new Product("cookies", 3, 2F, 2.3F);
        ArrayList<Product> toSell = new ArrayList<>();
        toSell.add(firstProduct);
        toSell.add(secondProduct);
        seller = new Seller(toSell);
        seller.attach(bank);
        bank.notifyUpdate();
    }

    @Test
    public void test_attaching_subscriber() {
        bank.attach(seller);
        assertEquals("test attaching subscriber", bank.getSubscribers().size(), 1);
    }

    @Test
    public void test_detaching_subscriber() {
        bank.attach(seller);
        bank.detach(seller);
        assertEquals("test detaching seller", bank.getSubscribers().size(), 0);
    }

    @Test
    public void test_correcting_inflation_on_increase_in_sales() {
        bank.attach(seller);
        buyer = new Buyer(toBuy) {
            public boolean tryToBuy(Product product) {
                return true;
            }
        };
        seller.attach(buyer);
        seller.notifyUpdate();
        bank.correctInflation();
        assertEquals("test correcting inflation on increase in sales", bank.getInflation(), 5.5F, 0.0001);
    }

    @Test
    public void test_correcting_inflation_on_decrease_in_sales() {
        bank.attach(seller);
        buyer = new Buyer(toBuy) {
            public boolean tryToBuy(Product product) {
                return true;
            }
        };
        seller.attach(buyer);
        seller.notifyUpdate();
        bank.correctInflation();
        bank.correctInflation();
        bank.correctInflation();
        assertEquals("test correcting inflation on increase in sales", bank.getInflation(), 4.5F, 0.0001);
    }

    @Test
    public void test_updating_subscribers() {
        bank.attach(seller);
        buyer = new Buyer(toBuy);
        seller.attach(buyer);
        seller.notifyUpdate();
        bank.correctInflation();
        bank.notifyUpdate();
        assertEquals("test updating subscribers", bank.getInflation(), seller.getInflation(), 0.0001);

    }

    @Test
    public void test_updating_from_seller_on_sell() {
        bank.attach(seller);
        buyer = new Buyer(toBuy) {
            public boolean tryToBuy(Product product) {
                return true;
            }
        };
        seller.attach(buyer);
        seller.notifyUpdate();
        assertEquals("test counting sold items", bank.getSoldItemsQuantity(), 2);
    }

}
