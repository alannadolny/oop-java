package Interfaces;

import Carts.SetCart;

public interface Discount {
    Discount setCart(SetCart cart);
    String getDiscountCode();
    boolean canApply(SetCart cart);
    void applyDiscount();
}
