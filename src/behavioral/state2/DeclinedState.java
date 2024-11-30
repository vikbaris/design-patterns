package behavioral.state2;

public class DeclinedState implements PaymentState {
    @Override
    public void processPayment(Payment payment) {
        System.out.println("Reddedilen ödeme tekrar işleme alınıyor.");
        payment.setState(new PendingState());
    }

    @Override
    public void approvePayment(Payment payment) {
        System.out.println("Hata: Reddedilen ödeme onaylanamaz!");
    }

    @Override
    public void declinePayment(Payment payment) {
        System.out.println("Hata: Ödeme zaten reddedilmiş!");
    }

    @Override
    public void refundPayment(Payment payment) {
        System.out.println("Hata: Reddedilen ödeme iade edilemez!");
    }

    @Override
    public String getStatus() {
        return "DECLINED";
    }
}
