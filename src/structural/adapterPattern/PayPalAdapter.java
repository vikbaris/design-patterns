package structural.adapterPattern;


public class PayPalAdapter implements PaymentProcessor {
    private final PayPalAPI paypalService;
    
    public PayPalAdapter() {
        this.paypalService = new PayPalAPI();
    }
    
    @Override
    public boolean processPayment(PaymentDetails paymentDetails) {
        try {
            // PayPal'ın beklediği formata dönüştürme işlemi
            String paypalTransactionId = paypalService.createPayment(
                paymentDetails.getCustomerId(),
                paymentDetails.getAmount(),
                paymentDetails.getCurrency()
            );
            
            // İşlem başarılı ise true döndür
            return paypalTransactionId != null && !paypalTransactionId.isEmpty();
        } catch (Exception e) {
            System.err.println("PayPal ödeme işlemi sırasında hata: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public PaymentStatus getPaymentStatus(String transactionId) {
        try {
            PayPalPaymentStatus paypalStatus = paypalService.checkPayment(transactionId);
            
            // PayPal'ın durumunu bizim sistemimizin anlayacağı duruma çevirme
            return switch (paypalStatus) {
                case COMPLETED -> PaymentStatus.SUCCESS;
                case PENDING -> PaymentStatus.PENDING;
                case FAILED -> PaymentStatus.FAILED;
                case REFUNDED -> PaymentStatus.REFUNDED;
                default -> PaymentStatus.UNKNOWN;
            };
        } catch (Exception e) {
            System.err.println("PayPal durum kontrolü sırasında hata: " + e.getMessage());
            return PaymentStatus.UNKNOWN;
        }
    }
    
    @Override
    public boolean refundPayment(String transactionId) {
        try {
            return paypalService.refund(transactionId, null);
        } catch (Exception e) {
            System.err.println("PayPal iade işlemi sırasında hata: " + e.getMessage());
            return false;
        }
    }
}