package behavioral.state;

public class ShippedState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Hata: Kargolanmış sipariş tekrar onaylanamaz!");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Hata: Sipariş zaten kargoda!");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Sipariş teslim edildi.");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Hata: Kargolanmış sipariş iptal edilemez!");
    }

    @Override
    public String getStatus() {
        return "SHIPPED";
    }
}
