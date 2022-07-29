package Carts;

import Products.*;

import MyArrayList.ProductList;

public class SetCart {
    private final ProductList productList = new ProductList();
    private final ProductList giftList = new ProductList();

    public double calculateCost() {
        double sum = 0;
        for (Product el : productList.getList()) {
            sum = sum + el.getDiscountPrice();
        }
        return sum;
    }

    public int getGiftsListLength() {
        return this.giftList.getList().length;
    }


    public ProductList getGiftList() {
        return this.giftList;
    }

    public void addGift(Product product) {
        this.giftList.add(product);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProduct(Product product) {
        productList.remove(product);
    }

    public ProductList getProductList() {
        return productList;
    }

    public Product getProduct(int index) {
        return productList.get(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Product el : productList.getList()) {
            if (el.getDiscountPrice() != el.getPrice()) {
                res.append("name: ")
                        .append(el.getName())
                        .append(", price: ")
                        .append(el.getPrice())
                        .append(", discount price: ")
                        .append(String.format(String.valueOf(el.getDiscountPrice()), "%.2f"))
                        .append("\n");
            } else {
                res.append("name: ")
                        .append(el.getName())
                        .append(", price: ")
                        .append(el.getPrice())
                        .append("\n");
            }
        }
        return res.toString();
    }

}
