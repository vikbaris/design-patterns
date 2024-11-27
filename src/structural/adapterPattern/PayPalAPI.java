package structural.adapterPattern;

import java.math.BigDecimal;

// Bu sınıf PayPal'ın kendi API'sini temsil ediyor
public class PayPalAPI {
    public String createPayment(String email, BigDecimal total, String currency) {
        // PayPal'a özgü ödeme oluşturma mantığı
        System.out.println("PayPal ödeme işlemi başlatıldı: " + email);
        return "PP-" + System.currentTimeMillis();
    }

    public PayPalPaymentStatus checkPayment(String paypalTransactionId) {
        // PayPal'a özgü ödeme durumu kontrolü
        return PayPalPaymentStatus.COMPLETED;
    }

    public boolean refund(String paypalTransactionId, BigDecimal amount) {
        // PayPal'a özgü iade işlemi
        System.out.println("PayPal iade işlemi: " + paypalTransactionId);
        return true;
    }
}

enum PayPalPaymentStatus {
    PENDING, COMPLETED, FAILED, REFUNDED
}