package structural;

/*
 * Bridge tasarım deseni, soyutlama (abstraction) ile implementasyonu birbirinden ayırmaya yarayan 
 * yapısal (structural) bir tasarım desenidir. Bu desen, büyük sınıfları veya birbiriyle yakından ilişkili
 *  sınıfları iki ayrı hiyerarşiye (soyutlama ve implementasyon) ayırmanıza olanak tanır.


Örnekte NotificationChannel ile Notification iki ayrı yapı olarak geliştirilip, daha sonra yeni bir notification yollama
 geliştirmesini yapmak için yeni bir kod yazmaya gerek kalmayacak.
 */

// Bildirim Gönderme Kanalları (Implementation)

interface NotificationChannel {
    void sendMessage(String message, String recipient);
}

class SMSChannel implements NotificationChannel {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS Gönderiliyor: " + message + 
                           " - Alıcı: " + recipient);
    }
}

class EmailChannel implements NotificationChannel {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("E-posta Gönderiliyor: " + message + 
                           " - Alıcı: " + recipient);
    }
}

class PushNotificationChannel implements NotificationChannel {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Push Bildirimi Gönderiliyor: " + message + 
                           " - Alıcı: " + recipient);
    }
}

// Bildirim Türleri (Abstraction)
abstract class Notification {
    // Bridge bağlantısı
    protected NotificationChannel channel;

    public Notification(NotificationChannel channel) {
        this.channel = channel;
    }

    public abstract void send(String message, String recipient);
}

// Somut Bildirim Sınıfları
class SimpleNotification extends Notification {
    public SimpleNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void send(String message, String recipient) {
        channel.sendMessage("Normal: " + message, recipient);
    }
}

class UrgentNotification extends Notification {
    public UrgentNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void send(String message, String recipient) {
        channel.sendMessage("ACİL: " + message.toUpperCase(), recipient);
    }
}

class CriticalNotification extends Notification {
    public CriticalNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void send(String message, String recipient) {
        // Kritik bildirimlerde ekstra log mekanizması
        System.out.println("Kritik Bildirim Loglanıyor...");
        channel.sendMessage("KRİTİK: " + message.toUpperCase(), recipient);
    }
}

// Örnek Kullanım
public class BridgePattern {
    public static void main(String[] args) {
        // Farklı kanallar ve bildirim türleri
        Notification smsSimple = new SimpleNotification(new SMSChannel());
        Notification emailUrgent = new UrgentNotification(new EmailChannel());
        Notification pushCritical = new CriticalNotification(new PushNotificationChannel());
        
        // Bildirimleri gönderme
        smsSimple.send("Sipariş onaylandı", "+90 555 123 45 67");
        emailUrgent.send("Ödeme hatası", "musteri@ornek.com");
        pushCritical.send("Güvenlik ihlali algılandı", "admin@sirket.com");
    }
}