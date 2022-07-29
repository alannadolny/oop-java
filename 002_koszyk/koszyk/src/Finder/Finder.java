package Finder;

import Products.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import MyArrayList.ProductList;

public class Finder {

    ProductList productsList;

    public void setProductsList(ProductList productsList) {
        this.productsList = productsList;
    }

    public Product getTheCheapestProduct() {
        Product minProduct = this.productsList.get(0);
        ProductsComparator comparator = new ProductsComparator();
        for(int i = 0; i < this.productsList.getList().length; i++) {
            if (comparator.compare(minProduct, this.productsList.get(i)) > 0) minProduct = this.productsList.get(i);
        }
        return minProduct;
    }

    public Product getTheMostExpensiveProduct() {
    Product maxProduct = this.productsList.get(0);
    ProductsComparator comparator = new ProductsComparator();
        for(int i = 0; i < this.productsList.getList().length; i++) {
        if (comparator.compare(maxProduct, this.productsList.get(i)) < 0) maxProduct = this.productsList.get(i);
    }
        return maxProduct;
    }

    public ProductList getNTheMostExpensiveProducts(int n) {
        Arrays.sort(this.productsList.getList(), new ProductsComparator());
        this.productsList.reverse();
        return new ProductList(Arrays.copyOf(this.productsList.getList(), n));
    }


    public ProductList getNTheCheapestProducts(int n) {
        Arrays.sort(this.productsList.getList(), new ProductsComparator());
        return new ProductList(Arrays.copyOf(this.productsList.getList(), n));
    }

    public ProductList getSortedListByPrice() {
        Arrays.sort(this.productsList.getList(), new ProductsComparator());
        return this.productsList;
    }

    public ProductList getSortedListByName() {
        Arrays.sort(this.productsList.getList(), new ProductsComparatorByName());
        return this.productsList;
    }
}
