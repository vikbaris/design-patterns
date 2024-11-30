package behavioral.state;

public class DeliveredState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Hata: Teslim edilmiş sipariş tekrar onaylanamaz!");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Hata: Teslim edilmiş sipariş kargolanamaz!");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Hata: Sipariş zaten teslim edilmiş!");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Hata: Teslim edilmiş sipariş iptal edilemez!");
    }

    @Override
    public String getStatus() {
        return "DELIVERED";
    }
}
