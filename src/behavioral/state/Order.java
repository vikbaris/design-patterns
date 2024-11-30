package behavioral.state;

public class Order {
    private OrderState state;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
        // Başlangıç durumu NEW
        this.state = new NewState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void confirmOrder() {
        System.out.println("\nSipariş #" + orderId + " için onaylama işlemi:");
        state.confirmOrder(this);
    }

    public void shipOrder() {
        System.out.println("\nSipariş #" + orderId + " için kargolama işlemi:");
        state.shipOrder(this);
    }

    public void deliverOrder() {
        System.out.println("\nSipariş #" + orderId + " için teslim işlemi:");
        state.deliverOrder(this);
    }

    public void cancelOrder() {
        System.out.println("\nSipariş #" + orderId + " için iptal işlemi:");
        state.cancelOrder(this);
    }

    public String getStatus() {
        return state.getStatus();
    }
}
