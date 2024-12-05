package creational.factoryPattern;

public class Espresso implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Özel İtalyan kahve çekirdekleri öğütülüyor...");
    }

    @Override
    public void brew() {
        System.out.println("Yüksek basınçlı sıcak su ile espresso hazırlanıyor...");
    }

    @Override
    public void addCondiments() {
        System.out.println("Sade espresso, ek malzeme eklenmedi.");
    }

    @Override
    public double getPrice() {
        return 4.50;
    }

    @Override
    public String getDescription() {
        return "Klasik İtalyan Espresso - Yoğun ve güçlü";
    }
}
