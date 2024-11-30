package behavioral.command;

// Receiver sınıfı
public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " ışıkları açıldı");
    }

    public void turnOff() {
        System.out.println(location + " ışıkları kapatıldı");
    }
}
