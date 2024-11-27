package FacadePattern;

/*
 * Facade (Cephe) Pattern, karmaşık bir alt sistem veya kütüphaneye basit bir arayüz sağlayan yapısal bir tasarım modelidir.
 */

// Alt Sistemler
class LightSystem {
    public void turnOnLights() {
        System.out.println("Tüm ışıklar açılıyor");
    }
    
    public void turnOffLights() {
        System.out.println("Tüm ışıklar kapatılıyor");
    }
}

class SecuritySystem {
    public void activateAlarm() {
        System.out.println("Güvenlik sistemi devreye girdi");
    }
    
    public void deactivateAlarm() {
        System.out.println("Güvenlik sistemi devre dışı bırakıldı");
    }
}

class HeatingSystem {
    public void setTemperature(int derece) {
        System.out.println("Sıcaklık " + derece + " dereceye ayarlandı");
    }
}

// Facade Sınıfı
class SmartHomeFacade {
    private LightSystem lightSystem;
    private SecuritySystem securitySystem;
    private HeatingSystem heatingSystem;

    public SmartHomeFacade() {
        this.lightSystem = new LightSystem();
        this.securitySystem = new SecuritySystem();
        this.heatingSystem = new HeatingSystem();
    }

    // Evden Çıkış Senaryosu
    public void leaveHome() {
        System.out.println("Evden Çıkış Senaryosu Başlatılıyor:");
        lightSystem.turnOffLights();
        securitySystem.activateAlarm();
        heatingSystem.setTemperature(16); // Enerji tasarrufu
    }

    // Eve Dönüş Senaryosu
    public void arriveHome() {
        System.out.println("Eve Dönüş Senaryosu Başlatılıyor:");
        securitySystem.deactivateAlarm();
        lightSystem.turnOnLights();
        heatingSystem.setTemperature(22); // Konfor sıcaklığı
    }
}

// Kullanım Örneği
public class FacadePatternDemo {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();
        
        // Evden çıkış
        smartHome.leaveHome();
        
        // Eve dönüş
        smartHome.arriveHome();
    }
}