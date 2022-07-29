package Interfaces;

public interface Publisher {
    void attach(Subscriber o);

    void detach(Subscriber o);

    void notifyUpdate();
}
