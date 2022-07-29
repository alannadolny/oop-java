package Discounts;

import Interfaces.*;
import Products.*;
import Carts.*;

public class DiscountIfOrderMoreExpensiveThan200 implements Discount {

    private SetCart cart = new SetCart();
    private final String discountCode;

    public DiscountIfOrderMoreExpensiveThan200(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    @Override
    public boolean canApply(SetCart cart) {
        return cart.calculateCost() >= 200;
    }

    @Override
    public Discount setCart(SetCart cart) {
        this.cart = cart;
        return this;
    }

    @Override
    public void applyDiscount() {
        this.cart.addGift(new Product(0, "gift", "mug"));
    }
}
