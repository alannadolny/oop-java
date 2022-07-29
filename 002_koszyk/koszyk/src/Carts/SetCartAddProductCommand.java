package Carts;

import Interfaces.*;
import Products.*;

public class SetCartAddProductCommand implements Command {

    SetCart setCart;
    Product newProduct;

    public SetCartAddProductCommand(SetCart setCart, Product newProduct) {
        this.setCart = setCart;
        this.newProduct = newProduct;
    }

    @Override
    public void execute() {
        setCart.addProduct(this.newProduct);
    }
}
