package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

// Context sınıfı - Stratejiyi kullanan sınıf
public class ShoppingCart {
    private List<Double> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(double price) {
        items.add(price);
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public boolean checkout() {
        double total = calculateTotal();
        return paymentStrategy.pay(total);
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(Double::doubleValue).sum();
    }

    public String getCurrentPaymentMethod() {
        return paymentStrategy != null ? paymentStrategy.getPaymentMethod() : "Ödeme yöntemi seçilmedi";
    }
}
