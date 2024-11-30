package behavioral.state2;

public interface PaymentState {
    void processPayment(Payment payment);
    void approvePayment(Payment payment);
    void declinePayment(Payment payment);
    void refundPayment(Payment payment);
    String getStatus();
}
