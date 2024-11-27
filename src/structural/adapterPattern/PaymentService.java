package structural.adapterPattern;

public class PaymentService {
    private final PaymentProcessor paymentProcessor;

    public PaymentService(String paymentMethod) {
        // Ödeme yöntemine göre uygun adapter'ı seç
        switch (paymentMethod.toLowerCase()) {
            case "paypal":
                this.paymentProcessor = new PayPalAdapter();
                break;
            // Diğer ödeme yöntemleri için farklı adapter'lar eklenebilir
            default:
                throw new IllegalArgumentException("Desteklenmeyen ödeme yöntemi: " + paymentMethod);
        }
    }

    public boolean processPayment(PaymentDetails paymentDetails) {
        return paymentProcessor.processPayment(paymentDetails);
    }

    public PaymentStatus checkPaymentStatus(String transactionId) {
        return paymentProcessor.getPaymentStatus(transactionId);
    }

    public boolean refundPayment(String transactionId) {
        return paymentProcessor.refundPayment(transactionId);
    }
}   