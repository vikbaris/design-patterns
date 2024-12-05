package behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String cardNumber, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public boolean pay(double amount) {
        // Gerçek uygulamada burada kredi kartı işlemi yapılır
        System.out.println(amount + " TL kredi kartı ile ödendi: " + cardNumber);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Kredi Kartı";
    }
}
