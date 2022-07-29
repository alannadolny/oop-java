package Discounts;

import Interfaces.*;
import Products.*;
import Carts.*;

import java.util.Arrays;

public class DiscountIfBuy3Products implements Discount {

    private SetCart cart;
    private final String discountCode;

    public String getDiscountCode() {
        return discountCode;
    }


    public DiscountIfBuy3Products(String discountCode) {
        this.discountCode = discountCode;
    }

    @Override
    public Discount setCart(SetCart cart) {
        this.cart = cart;
        return this;
    }

    @Override
    public boolean canApply(SetCart cart) {
        return ((cart.getProductList().getList().length) / 3) > 0;
    }

    @Override
    public void applyDiscount() {
        int freeProductsQuantity = ((this.cart.getProductList().getList().length) / 3);
        Arrays.sort(this.cart.getProductList().getList(), new ProductsComparator());
        for (int i = 0; i < freeProductsQuantity; i++) {
            this.cart.getProduct(i).setDiscountPrice(0);
        }
    }
}
