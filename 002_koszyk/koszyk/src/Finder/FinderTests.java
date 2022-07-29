package Finder;

import Carts.SetCart;
import Carts.SetCartAddProductCommand;
import org.junit.*;
import Products.*;
import Carts.*;

import MyArrayList.ProductList;

import static org.junit.Assert.assertEquals;


public class FinderTests {
    CartCommand cartCommand = new CartCommand();
    Finder finder = new Finder();
    SetCart cart;

    @Before
    public void before() {
        cart = new SetCart();
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(150, "test", "ddd")));
        cartCommand.executeCommand();
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(250, "test2", "bca")));
        cartCommand.executeCommand();
        cartCommand.setCommand(new SetCartAddProductCommand(cart, new Product(80, "test3", "aaa")));
        cartCommand.executeCommand();
        finder.setProductsList(cart.getProductList());
    }

    @Test
    public void test_getting_the_cheapest_product() {
        Product theCheapest = finder.getTheCheapestProduct();
        double result = theCheapest.getPrice();
        assertEquals("getting the cheapest item", 80, result, 0.0001);
    }

    @Test
    public void test_getting_the_most_expensive_product() {
        Product theMostExpensive = finder.getTheMostExpensiveProduct();
        double result = theMostExpensive.getDiscountPrice();
        assertEquals("getting the most expensive item", 250, result, 0.0001);
    }

    @Test
    public void test_getting_2_the_cheapest_products() {
        ProductList theCheapestProducts = finder.getNTheCheapestProducts(2);
        Assert.assertEquals("getting the cheapest item, first", 80, theCheapestProducts.get(0).getDiscountPrice(), 0.0001);
        Assert.assertEquals("getting the cheapest item, second", 150, theCheapestProducts.get(1).getDiscountPrice(), 0.0001);

    }

    @Test
    public void test_getting_2_the_most_expensive_products() {
        ProductList theMostExpensiveProducts = finder.getNTheMostExpensiveProducts(2);
        Assert.assertEquals("getting the most expensive item, first", 250, theMostExpensiveProducts.get(0).getDiscountPrice(), 0.0001);
        Assert.assertEquals("getting the most expensive item, second", 150, theMostExpensiveProducts.get(1).getDiscountPrice(), 0.0001);
    }

    @Test
    public void test_getting_sorted_list_by_price() {
        ProductList sortedListByPrice = finder.getSortedListByPrice();
        Assert.assertEquals("sorted by price, first item", 80, sortedListByPrice.get(0).getDiscountPrice(), 0.0001);
        Assert.assertEquals("sorted by price, second item", 150, sortedListByPrice.get(1).getDiscountPrice(), 0.0001);
        Assert.assertEquals("sorted by price, third item", 250, sortedListByPrice.get(2).getDiscountPrice(), 0.0001);

    }

    @Test
    public void test_getting_sorted_list_by_name() {
        ProductList sortedListByName = finder.getSortedListByName();
        Assert.assertEquals("sorted by name, first item", "aaa", sortedListByName.get(0).getName());
        Assert.assertEquals("sorted by name, second item", "bca", sortedListByName.get(1).getName());
        Assert.assertEquals("sorted by name, third item", "ddd", sortedListByName.get(2).getName());
    }

}
