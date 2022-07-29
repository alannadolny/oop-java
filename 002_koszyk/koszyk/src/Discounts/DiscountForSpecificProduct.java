package Discounts;

import Interfaces.*;
import Products.*;
import Carts.*;

public class DiscountForSpecificProduct implements Discount {

    private SetCart cart;
    private final String productCode;
    private final String discountCode;

    public String getDiscountCode() {
        return discountCode;
    }

    @Override
    public boolean canApply(SetCart cart) {
        return cart.getProductList().find(this.productCode) != null;
    }

    public DiscountForSpecificProduct(String productCode, String discountCode) {
        this.productCode = productCode;
        this.discountCode = discountCode;
    }

    @Override
    public Discount setCart(SetCart cart) {
        this.cart = cart;
        return this;
    }

    @Override
    public void applyDiscount() {
        Product prod = this.cart.getProductList().find(this.productCode);
        prod.setDiscountPrice(prod.getDiscountPrice() * 0.7);
    }
}
