package MyArrayList;

import Discounts.DiscountIfOrderMoreExpensiveThan300;
import Products.Product;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ListsTest {

    ProductList productList;
    DiscountList discountList;

    @Before
    public void before() {
        productList = new ProductList();
        discountList = new DiscountList();
    }

    @Test
    public void test_add_product() {
        productList.add(new Product(20, "test_code", "test_name"));
        assertEquals("test add product to list", 1, productList.getList().length);
    }

    @Test
    public void test_add_discount() {
        discountList.add(new DiscountIfOrderMoreExpensiveThan300("300"));
        assertEquals("test add discount to list", 1, discountList.getList().length);
    }

    @Test
    public void test_remove_product() {
        productList.add(new Product(20, "test_code", "test_name"));
        productList.remove(new Product(20, "test_code", "test_name"));
        assertEquals("test add product to list", 0, productList.getList().length);
    }

    @Test
    public void test_remove_discount() {
        discountList.add(new DiscountIfOrderMoreExpensiveThan300("300"));
        discountList.remove("300");
        assertEquals("test add discount to list", 0, discountList.getList().length);
    }

    @Test
    public void test_find_product() {
        productList.add(new Product(20, "test_code", "test_name"));
        productList.add(new Product(30, "test_code2", "test_name2"));
        productList.add(new Product(40, "test_code3", "test_name3"));
        productList.add(new Product(50, "test_code4", "test_name4"));
        Product foundProduct = productList.find("test_code2");
        assertEquals("test found Product name", "test_name2", foundProduct.getName());
        assertEquals("test found Product price", 30, foundProduct.getPrice());
        assertEquals("test found Product code", "test_code2", foundProduct.getCode());
    }

    @Test
    public void test_reverse_product_list() {
        productList.add(new Product(20, "test_code", "test_name"));
        productList.add(new Product(30, "test_code2", "test_name2"));
        productList.add(new Product(40, "test_code3", "test_name3"));
        productList.add(new Product(50, "test_code4", "test_name4"));
        productList.reverse();
        assertEquals("test first product", "test_code4", productList.get(0).getCode());
        assertEquals("test second product", "test_code3", productList.get(1).getCode());
        assertEquals("test third product", "test_code2", productList.get(2).getCode());
        assertEquals("test fourth product", "test_code", productList.get(3).getCode());
    }
}
