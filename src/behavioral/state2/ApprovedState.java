package behavioral.state2;

public class ApprovedState implements PaymentState {
    @Override
    public void processPayment(Payment payment) {
        System.out.println("Hata: Onaylanmış ödeme tekrar işleme alınamaz!");
    }

    @Override
    public void approvePayment(Payment payment) {
        System.out.println("Hata: Ödeme zaten onaylanmış!");
    }

    @Override
    public void declinePayment(Payment payment) {
        System.out.println("Hata: Onaylanmış ödeme reddedilemez!");
    }

    @Override
    public void refundPayment(Payment payment) {
        System.out.println("Ödeme iade edildi.");
        payment.setState(new RefundedState());
    }

    @Override
    public String getStatus() {
        return "APPROVED";
    }
}
