package structural.adapterPattern;

public interface PaymentProcessor {
    boolean processPayment(PaymentDetails paymentDetails);
    PaymentStatus getPaymentStatus(String transactionId);
    boolean refundPayment(String transactionId);
}