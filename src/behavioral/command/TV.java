package behavioral.command;

// Receiver sınıfı
public class TV {
    private String location;
    private int volume;

    public TV(String location) {
        this.location = location;
        this.volume = 0;
    }

    public void turnOn() {
        System.out.println(location + " TV açıldı");
    }

    public void turnOff() {
        System.out.println(location + " TV kapatıldı");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " TV ses seviyesi: " + volume);
    }
}
