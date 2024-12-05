package creational.factoryPattern;

public class Cappuccino implements Coffee {
    @Override
    public void prepare() {
        System.out.println("İtalyan kahve çekirdekleri Cappuccino için öğütülüyor...");
    }

    @Override
    public void brew() {
        System.out.println("Espresso hazırlanıyor ve süt özel teknikle köpürtülüyor...");
    }

    @Override
    public void addCondiments() {
        System.out.println("Eşit oranda buharlanmış süt ve kadifemsi süt köpüğü ekleniyor...");
    }

    @Override
    public double getPrice() {
        return 5.00;
    }

    @Override
    public String getDescription() {
        return "Geleneksel İtalyan Cappuccino - Mükemmel süt köpüğü oranı";
    }
}
