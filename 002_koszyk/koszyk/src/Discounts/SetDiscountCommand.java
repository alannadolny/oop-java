package Discounts;

import Carts.SetCart;
import Interfaces.Command;
import Interfaces.Discount;

public class SetDiscountCommand implements Command {

    SetCart setCart;
    Discount discount;

    public SetDiscountCommand(SetCart setCart, Discount discount) {
        this.setCart = setCart;
        this.discount = discount;
    }

    @Override
    public void execute() {
        if(discount.canApply(this.setCart)) discount.setCart(this.setCart).applyDiscount();
    }
}
