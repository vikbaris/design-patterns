package behavioral.state;

public class CancelledState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Hata: İptal edilmiş sipariş onaylanamaz!");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Hata: İptal edilmiş sipariş kargolanamaz!");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Hata: İptal edilmiş sipariş teslim edilemez!");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Hata: Sipariş zaten iptal edilmiş!");
    }

    @Override
    public String getStatus() {
        return "CANCELLED";
    }
}
