package behavioral.state;

// State interface - Tüm sipariş durumları bu arayüzü uygular
public interface OrderState {
    void confirmOrder(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
    void cancelOrder(Order order);
    String getStatus();
}
