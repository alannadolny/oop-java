package Discounts;

import Interfaces.*;
import Products.*;
import Carts.*;

public class DiscountIfOrderMoreExpensiveThan300 implements Discount {

    private SetCart cart;
    private final String discountCode;

    public DiscountIfOrderMoreExpensiveThan300(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    @Override
    public boolean canApply(SetCart cart) {
        return cart.calculateCost() >= 300;
    }

    @Override
    public Discount setCart(SetCart cart) {
        this.cart = cart;
        return this;
    }

    @Override
    public void applyDiscount() {
        if (this.cart.calculateCost() >= 300)
            for (Product el : cart.getProductList().getList()) {
                el.setDiscountPrice(el.getPrice() * 0.95);
            }
    }
}
