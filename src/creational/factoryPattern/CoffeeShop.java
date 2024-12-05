package creational.factoryPattern;

public class CoffeeShop {
    public static void main(String[] args) {
        // Farklı kahve fabrikaları oluştur
        CoffeeFactory espressoFactory = new EspressoFactory();
        CoffeeFactory latteFactory = new LatteFactory();
        CoffeeFactory cappuccinoFactory = new CappuccinoFactory();

        System.out.println("\n=== Espresso Siparişi ===");
        Coffee espresso = espressoFactory.orderCoffee();
        System.out.println("Fiyat: " + espresso.getPrice() + " TL");
        System.out.println("Açıklama: " + espresso.getDescription());

        System.out.println("\n=== Latte Siparişi ===");
        Coffee latte = latteFactory.orderCoffee();
        System.out.println("Fiyat: " + latte.getPrice() + " TL");
        System.out.println("Açıklama: " + latte.getDescription());

        System.out.println("\n=== Cappuccino Siparişi ===");
        Coffee cappuccino = cappuccinoFactory.orderCoffee();
        System.out.println("Fiyat: " + cappuccino.getPrice() + " TL");
        System.out.println("Açıklama: " + cappuccino.getDescription());
    }
}
