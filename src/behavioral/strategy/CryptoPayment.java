package behavioral.strategy;

public class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public boolean pay(double amount) {
        // Gerçek uygulamada burada kripto para transferi yapılır
        System.out.println(amount + " TL kripto para ile ödendi: " + walletAddress);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Kripto Para";
    }
}
