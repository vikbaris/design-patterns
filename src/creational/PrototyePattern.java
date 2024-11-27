package creational;

import java.util.ArrayList;
import java.util.List;

// Prototip arayüzü
interface CarPrototype extends Cloneable {
    CarPrototype clone();
    String getDetails();
}

// Temel araba sınıfı
abstract class Car implements CarPrototype {
    protected String model;
    protected String color;
    protected String engine;
    protected List<String> features;

    public Car() {
        features = new ArrayList<>();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void addFeature(String feature) {
        this.features.add(feature);
    }

    public void addFeatures(List<String> newFeatures) {
        this.features.addAll(newFeatures);
    }

    @Override
    public CarPrototype clone() {
        Car clone = null;
        try {
            clone = (Car) super.clone();
            clone.features = new ArrayList<>(this.features);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String getDetails() {
        return String.format("Model: %s, Renk: %s, Motor: %s, Özellikler: %s",
                model, color, engine, features.toString());
    }
}

// Spor araba sınıfı
class SportsCar extends Car {
    public SportsCar() {
        model = "Spor Araba";
        color = "Kırmızı";
        engine = "3.0L V6";
        features.add("Spor Süspansiyon");
        features.add("Karbon Fiber Parçalar");
    }
}

// SUV araba sınıfı
class SUV extends Car {
    public SUV() {
        model = "SUV";
        color = "Siyah";
        engine = "2.0L";
        features.add("Yüksek Sürüş");
        features.add("Geniş Bagaj");
    }
}

// Fabrika sınıfı
class CarFactory {
    private CarPrototype sportsPrototype;
    private CarPrototype suvPrototype;

    public CarFactory() {
        sportsPrototype = new SportsCar();
        suvPrototype = new SUV();
    }

    public CarPrototype createSportsCar(String color, List<String> features) {
        CarPrototype car = sportsPrototype.clone();
        if (color != null) {
            ((Car) car).setColor(color);
        }
        if (features != null) {
            ((Car) car).addFeatures(features);
        }
        return car;
    }

    public CarPrototype createSUV(String color, List<String> features) {
        CarPrototype car = suvPrototype.clone();
        if (color != null) {
            ((Car) car).setColor(color);
        }
        if (features != null) {
            ((Car) car).addFeatures(features);
        }
        return car;
    }
}

// Ana sınıf
public class PrototyePattern {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        // Standart spor araba üretimi
        CarPrototype sportsCar1 = factory.createSportsCar(null, null);
        System.out.println("Spor Araba 1: " + sportsCar1.getDetails());

        // Özelleştirilmiş spor araba üretimi
        List<String> sportsFeatures = new ArrayList<>();
        sportsFeatures.add("Panoramik Tavan");
        CarPrototype sportsCar2 = factory.createSportsCar("Mavi", sportsFeatures);
        System.out.println("Spor Araba 2: " + sportsCar2.getDetails());

        // Standart SUV üretimi
        CarPrototype suv1 = factory.createSUV(null, null);
        System.out.println("SUV 1: " + suv1.getDetails());

        // Özelleştirilmiş SUV üretimi
        List<String> suvFeatures = new ArrayList<>();
        suvFeatures.add("360 Derece Kamera");
        CarPrototype suv2 = factory.createSUV("Beyaz", suvFeatures);
        System.out.println("SUV 2: " + suv2.getDetails());
    }
}