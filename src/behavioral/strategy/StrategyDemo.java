package behavioral.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        // Alışveriş sepeti oluştur
        ShoppingCart cart = new ShoppingCart();
        
        // Ürünleri sepete ekle
        cart.addItem(100);
        cart.addItem(50);
        cart.addItem(75);

        // Kredi kartı ile ödeme
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "123", "12/25"));
        System.out.println("Ödeme yöntemi: " + cart.getCurrentPaymentMethod());
        cart.checkout();

        // PayPal ile ödeme
        cart.setPaymentStrategy(new PayPalPayment("example@email.com", "password"));
        System.out.println("Ödeme yöntemi: " + cart.getCurrentPaymentMethod());
        cart.checkout();

        // Kripto para ile ödeme
        cart.setPaymentStrategy(new CryptoPayment("0x742d35Cc6634C0532925a3b844Bc454e4438f44e"));
        System.out.println("Ödeme yöntemi: " + cart.getCurrentPaymentMethod());
        cart.checkout();
    }
}
