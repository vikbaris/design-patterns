package creational.factoryPattern;

public class Latte implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Taze kahve çekirdekleri Latte için öğütülüyor...");
    }

    @Override
    public void brew() {
        System.out.println("Espresso hazırlanıyor ve süt buharlanıyor...");
    }

    @Override
    public void addCondiments() {
        System.out.println("Buharlanmış süt ve ince süt köpüğü ekleniyor...");
    }

    @Override
    public double getPrice() {
        return 5.50;
    }

    @Override
    public String getDescription() {
        return "Kadifemsi Latte - Espresso ve buharlanmış süt uyumu";
    }
}
