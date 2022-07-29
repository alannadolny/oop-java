package CentralBank;

import Interfaces.BankToSellerSubscriber;
import Interfaces.Publisher;
import Interfaces.Subscriber;

import java.util.ArrayList;

public class Bank implements Publisher, BankToSellerSubscriber {

    private int previousSoldItemsQuantity;
    private int soldItemsQuantity;
    private float inflation;
    private final ArrayList<Subscriber> subscribers = new ArrayList<>();

    public Bank() {
        this.previousSoldItemsQuantity = 0;
    }

    public void correctInflation() {
        if (this.previousSoldItemsQuantity >= this.soldItemsQuantity) this.setInflation(this.inflation - 0.5F);
        else this.setInflation(this.inflation + 0.5F);
        this.previousSoldItemsQuantity = this.soldItemsQuantity;
        this.soldItemsQuantity = 0;
    }

    public ArrayList<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setInflation(float inflation) {
        this.inflation = inflation;
    }

    public int getSoldItemsQuantity() {
        return soldItemsQuantity;
    }

    public float getInflation() {
        return inflation;
    }

    @Override
    public void attach(Subscriber o) {
        this.subscribers.add(o);
    }

    @Override
    public void detach(Subscriber o) {
        this.subscribers.remove(o);
    }

    @Override
    public void notifyUpdate() {
        for (Subscriber sub : this.subscribers)
            sub.update(this.inflation);
    }

    @Override
    public void updateFromSeller() {
        this.soldItemsQuantity++;
    }
}
