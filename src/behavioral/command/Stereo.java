package behavioral.command;

// Receiver sınıfı
public class Stereo {
    private String location;
    private int volume;

    public Stereo(String location) {
        this.location = location;
        this.volume = 0;
    }

    public void turnOn() {
        System.out.println(location + " müzik sistemi açıldı");
    }

    public void turnOff() {
        System.out.println(location + " müzik sistemi kapatıldı");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " müzik sistemi ses seviyesi: " + volume);
    }
}
