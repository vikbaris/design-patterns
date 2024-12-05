package behavioral.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        // Haber ajansını oluştur
        NewsAgency newsAgency = new NewsAgency();

        // Haber kanallarını oluştur
        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");
        NewsChannel ntv = new NewsChannel("NTV");

        // Email abonelerini oluştur
        EmailSubscriber emailSubscriber1 = new EmailSubscriber("user1@example.com");
        EmailSubscriber emailSubscriber2 = new EmailSubscriber("user2@example.com");

        // Mobil uygulama abonelerini oluştur
        MobileAppSubscriber mobileUser1 = new MobileAppSubscriber("John", "token123");
        MobileAppSubscriber mobileUser2 = new MobileAppSubscriber("Jane", "token456");

        // Observerları kaydet
        newsAgency.addObserver(cnn);
        newsAgency.addObserver(bbc);
        newsAgency.addObserver(ntv);
        newsAgency.addObserver(emailSubscriber1);
        newsAgency.addObserver(emailSubscriber2);
        newsAgency.addObserver(mobileUser1);
        newsAgency.addObserver(mobileUser2);

        // Yeni haber yayınla
        System.out.println("İLK HABER YAYINLANIYOR...\n");
        newsAgency.setNews("Önemli gelişme: Yeni bir teknolojik buluş yapıldı!");

        System.out.println("\nBBC KANALINI ÇIKAR VE YENİ HABER YAYINLA...\n");
        // BBC'yi çıkar ve yeni haber yayınla
        newsAgency.removeObserver(bbc);
        newsAgency.setNews("Son dakika: Spor müsabakasında rekor kırıldı!");
    }
}
