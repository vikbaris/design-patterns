package behavioral.state2;

public class PendingState implements PaymentState {
    @Override
    public void processPayment(Payment payment) {
        System.out.println("Hata: Ödeme zaten işleme alınmış!");
    }

    @Override
    public void approvePayment(Payment payment) {
        System.out.println("Ödeme onaylandı.");
        payment.setState(new ApprovedState());
    }

    @Override
    public void declinePayment(Payment payment) {
        System.out.println("Ödeme reddedildi.");
        payment.setState(new DeclinedState());
    }

    @Override
    public void refundPayment(Payment payment) {
        System.out.println("Hata: Bekleyen ödeme iade edilemez!");
    }

    @Override
    public String getStatus() {
        return "PENDING";
    }
}
