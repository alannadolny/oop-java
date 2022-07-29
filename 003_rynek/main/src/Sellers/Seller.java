package Sellers;

import Interfaces.*;
import Products.Product;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Seller implements Interfaces.Seller, Subscriber, SellerPublisher, BankToSellerPublisher {

    private ArrayList<Product> toSell;
    private float inflation;
    private final ArrayList<SellerSubscriber> observers = new ArrayList<>();
    private BankToSellerSubscriber bank;

    public float getInflation() {
        return inflation;
    }

    public BankToSellerSubscriber getBank() {
        return bank;
    }

    public ArrayList<SellerSubscriber> getObservers() {
        return observers;
    }

    public Seller(ArrayList<Product> toSell) {
        this.toSell = toSell;
    }

    public void sell(ArrayList<Boolean> sold) {
        for (int i = 0; i < sold.size(); i++) {
            if (sold.get(i)) {
                this.toSell.get(i).setQuantity(this.toSell.get(i).getQuantity() - 1);
                this.notifyBank();
            }
        }
        this.toSell = (ArrayList<Product>) this.toSell.stream().filter(el -> el.getQuantity() > 0).collect(Collectors.toList());
    }

    public Product getProduct(int index) {
        return this.toSell.get(index);
    }

    public ArrayList<Product> getToSell() {
        return toSell;
    }

    @Override
    public void accept(SellerVisitor visitor) {
        ArrayList<Float> newPrices = visitor.visit(this);
        for (int i = 0; i < newPrices.size(); i++) {
            this.getProduct(i).setPrice(newPrices.get(i));
        }
    }

    @Override
    public void update(float inflation) {
        this.inflation = inflation;
    }

    @Override
    public void attach(SellerSubscriber o) {
        this.observers.add(o);
    }

    @Override
    public void detach(SellerSubscriber o) {
        this.observers.remove(o);
    }

    @Override
    public void attach(BankToSellerSubscriber o) {
        this.bank = o;
    }

    @Override
    public void detach(BankToSellerSubscriber o) {
        this.bank = null;
    }

    @Override
    public void notifyBank() {
        this.bank.updateFromSeller();
    }

    @Override
    public void notifyUpdate() {
        for (SellerSubscriber o : this.observers) o.update(this);
    }
}
