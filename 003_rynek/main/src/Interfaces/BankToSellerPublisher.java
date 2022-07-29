package Interfaces;

public interface BankToSellerPublisher {
    void attach(BankToSellerSubscriber o);

    void detach(BankToSellerSubscriber o);

    void notifyBank();
}
