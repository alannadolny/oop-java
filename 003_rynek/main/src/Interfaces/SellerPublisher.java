package Interfaces;

public interface SellerPublisher {
    void attach(SellerSubscriber o);

    void detach(SellerSubscriber o);

    void notifyUpdate();
}
