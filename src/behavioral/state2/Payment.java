package behavioral.state2;

public class Payment {
    private PaymentState state;
    private String paymentId;
    private double amount;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        // Başlangıç durumu INITIATED
        this.state = new InitiatedState();
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void processPayment() {
        System.out.println("\nÖdeme #" + paymentId + " (" + amount + " TL) işleme alınıyor:");
        state.processPayment(this);
    }

    public void approvePayment() {
        System.out.println("\nÖdeme #" + paymentId + " onaylanıyor:");
        state.approvePayment(this);
    }

    public void declinePayment() {
        System.out.println("\nÖdeme #" + paymentId + " reddediliyor:");
        state.declinePayment(this);
    }

    public void refundPayment() {
        System.out.println("\nÖdeme #" + paymentId + " iade ediliyor:");
        state.refundPayment(this);
    }

    public String getStatus() {
        return state.getStatus();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }
}
