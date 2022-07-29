package Carts;

import Interfaces.*;
import Products.*;

public class SetCartDeleteProductCommand implements Command {
    SetCart setCart;
    Product product;

    public SetCartDeleteProductCommand(SetCart setCart, Product product) {
        this.setCart = setCart;
        this.product = product;
    }

    @Override
    public void execute() {
        setCart.deleteProduct(this.product);
    }
}
