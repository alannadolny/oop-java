package Buyers;

import Interfaces.SellerSubscriber;
import Interfaces.Subscriber;
import Products.Product;
import Sellers.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Buyer implements Subscriber, SellerSubscriber {

    private float inflation;
    private final HashMap<String, Float> toBuy;

    public Buyer(HashMap<String, Float> toBuy) {
        this.toBuy = toBuy;
    }

    @Override
    public void update(float inflation) {
        this.inflation = inflation;
    }

    public boolean tryToBuy(Product product) {
        if (!toBuy.containsKey(product.getName())) return false;
        else {
            Random rand = new Random();
            float decision = rand.nextFloat();
            float willingnesToBuy = toBuy.get((product.getName())) / product.getPrice();
            if (willingnesToBuy >= decision) this.toBuy.remove(product.getName());
            return willingnesToBuy >= decision;
        }
    }

    @Override
    public void update(Seller seller) {
        ArrayList<Boolean> sold = new ArrayList<>();
        for (Product product : seller.getToSell()) {
            sold.add(tryToBuy(product));
        }
        seller.sell(sold);
    }
}
