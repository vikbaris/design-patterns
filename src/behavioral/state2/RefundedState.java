package behavioral.state2;

public class RefundedState implements PaymentState {
    @Override
    public void processPayment(Payment payment) {
        System.out.println("Hata: İade edilmiş ödeme tekrar işleme alınamaz!");
    }

    @Override
    public void approvePayment(Payment payment) {
        System.out.println("Hata: İade edilmiş ödeme onaylanamaz!");
    }

    @Override
    public void declinePayment(Payment payment) {
        System.out.println("Hata: İade edilmiş ödeme reddedilemez!");
    }

    @Override
    public void refundPayment(Payment payment) {
        System.out.println("Hata: Ödeme zaten iade edilmiş!");
    }

    @Override
    public String getStatus() {
        return "REFUNDED";
    }
}
