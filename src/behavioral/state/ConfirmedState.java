package behavioral.state;

public class ConfirmedState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Hata: Sipariş zaten onaylanmış!");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Sipariş kargoya verildi.");
        order.setState(new ShippedState());
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Hata: Kargolanmamış sipariş teslim edilemez!");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Onaylanmış sipariş iptal edildi.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStatus() {
        return "CONFIRMED";
    }
}
