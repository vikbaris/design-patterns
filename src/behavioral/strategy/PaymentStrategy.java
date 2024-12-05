package behavioral.strategy;

// Strategy interface - Tüm ödeme stratejileri bu arayüzü implement edecek
public interface PaymentStrategy {
    boolean pay(double amount);
    String getPaymentMethod();
}
