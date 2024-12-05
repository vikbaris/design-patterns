package behavioral.strategy;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        // Gerçek uygulamada burada PayPal API'si kullanılır
        System.out.println(amount + " TL PayPal ile ödendi: " + email);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}
