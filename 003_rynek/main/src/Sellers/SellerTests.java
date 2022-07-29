package Sellers;

import Buyers.Buyer;
import CentralBank.Bank;
import Products.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SellerTests {

    Bank bank;
    HashMap<String, Float> toBuy;
    Seller seller;
    Buyer buyer;

    @Before
    public void setUp() {
        bank = new Bank();
        bank.setInflation(5);
        toBuy = new HashMap<>() {{
            put("chocolate", 7F);
            put("cookies", 7F);
        }};
        Product firstProduct = new Product("chocolate", 3, 1.2F, 2.3F);
        Product secondProduct = new Product("cookies", 3, 2F, 2.3F);
        Product thirdProduct = new Product("cake", 1, 2F, 2.3F);
        ArrayList<Product> toSell = new ArrayList<>();
        toSell.add(firstProduct);
        toSell.add(secondProduct);
        toSell.add(thirdProduct);
        seller = new Seller(toSell);
        bank.attach(seller);
        seller.attach(bank);
        bank.notifyUpdate();
        seller.accept(new Visitor());
        buyer = new Buyer(toBuy);
    }

    @Test
    public void test_sell_few_products() {
        ArrayList<Boolean> booleanArray = new ArrayList<>();
        booleanArray.add(true);
        booleanArray.add(true);
        booleanArray.add(false);
        seller.sell(booleanArray);
        assertEquals("test sell first product", seller.getProduct(0).getQuantity(), 2);
        assertEquals("test sell second product", seller.getProduct(1).getQuantity(), 2);
        assertEquals("test sell third product", seller.getProduct(2).getQuantity(), 1);

    }

    @Test
    public void test_sell_one_product() {
        ArrayList<Boolean> booleanArray = new ArrayList<>();
        booleanArray.add(true);
        booleanArray.add(false);
        booleanArray.add(false);
        seller.sell(booleanArray);
        assertEquals("test sell first product", seller.getProduct(0).getQuantity(), 2);
        assertEquals("test sell second product", seller.getProduct(1).getQuantity(), 3);
        assertEquals("test sell third product", seller.getProduct(2).getQuantity(), 1);
    }

    @Test
    public void test_sell_the_last_product() {
        ArrayList<Boolean> booleanArray = new ArrayList<>();
        booleanArray.add(false);
        booleanArray.add(false);
        booleanArray.add(true);
        seller.sell(booleanArray);
        assertEquals("test sell first product", seller.getProduct(0).getQuantity(), 3);
        assertEquals("test sell second product", seller.getProduct(1).getQuantity(), 3);
        assertEquals("test products quantity", seller.getToSell().size(), 2);
    }

    @Test
    public void test_attaching_bank() {
        seller.attach(bank);
        assertNotEquals("test attaching bank", seller.getBank(), null);
    }

    @Test
    public void test_detaching_bank() {
        seller.attach(bank);
        seller.detach(bank);
        assertNull("test detaching bank", seller.getBank());
    }

    @Test
    public void test_attaching_buyers() {
        seller.attach(buyer);
        assertEquals("test attaching buyers", seller.getObservers().size(), 1);
    }

    @Test
    public void test_detaching_buyers() {
        seller.attach(buyer);
        seller.detach(buyer);
        assertEquals("test detaching buyers", seller.getObservers().size(), 0);
    }

    @Test
    public void test_updating_buyers() {
        seller.attach(buyer);
        seller.notifyUpdate();
        assertEquals("test update buyers", seller.getProduct(0).getQuantity(), 2);
        assertEquals("test update buyers", seller.getProduct(1).getQuantity(), 2);
        assertEquals("test update buyers", seller.getProduct(2).getQuantity(), 1);
    }

    @Test
    public void test_notifying_bank() {
        seller.notifyBank();
        assertEquals("test notifying bank", 1, bank.getSoldItemsQuantity());
    }

    @Test
    public void test_accepting_visitor() {
        seller.attach(buyer);
        seller.attach(bank);
        bank.correctInflation();
        bank.notifyUpdate();
        seller.accept(new Visitor());
        assertEquals("test first product price", seller.getProduct(0).getPrice(), 3.66, 0.01);
        assertEquals("test second product price", seller.getProduct(1).getPrice(), 4.49, 0.01);
        assertEquals("test third product price", seller.getProduct(2).getPrice(), 4.49, 0.01);
    }
}
