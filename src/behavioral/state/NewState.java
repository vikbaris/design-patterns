package behavioral.state;

public class NewState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Sipariş onaylandı.");
        order.setState(new ConfirmedState());
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Hata: Onaylanmamış sipariş kargolanamaz!");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Hata: Onaylanmamış sipariş teslim edilemez!");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Sipariş iptal edildi.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStatus() {
        return "NEW";
    }
}
