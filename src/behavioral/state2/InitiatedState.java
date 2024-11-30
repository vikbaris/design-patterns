package behavioral.state2;

public class InitiatedState implements PaymentState {
    @Override
    public void processPayment(Payment payment) {
        System.out.println("Ödeme işleme alındı.");
        payment.setState(new PendingState());
    }

    @Override
    public void approvePayment(Payment payment) {
        System.out.println("Hata: İşleme alınmamış ödeme onaylanamaz!");
    }

    @Override
    public void declinePayment(Payment payment) {
        System.out.println("Hata: İşleme alınmamış ödeme reddedilemez!");
    }

    @Override
    public void refundPayment(Payment payment) {
        System.out.println("Hata: İşleme alınmamış ödeme iade edilemez!");
    }

    @Override
    public String getStatus() {
        return "INITIATED";
    }
}
