# Observer Design Pattern - Haber Ajansı Örneği

Bu proje, Observer tasarım deseninin bir haber ajansı sistemi üzerinden uygulanmasını göstermektedir. Observer Pattern, bir nesnenin durumundaki değişiklikleri diğer nesnelere otomatik olarak bildirmesini sağlayan bir davranışsal tasarım desenidir.

## Observer Pattern Nedir?

Observer Pattern, bir nesnenin durumundaki değişiklikleri izleyen ve bu değişikliklere tepki veren bir tasarım desenidir. Bu desen, "yayıncı-abone" veya "subject-observer" ilişkisi olarak da bilinir.

## Proje Yapısı

### 1. Subject (Observable)
- **[NewsAgency](NewsAgency.java)**
  - Haber ajansını temsil eden sınıf
  - Observer'ları (kanalları) yönetir
  - Yeni haber geldiğinde tüm observer'ları bilgilendirir
  - Temel işlemler:
    - `addObserver()`: Yeni kanal ekler
    - `removeObserver()`: Kanal çıkarır
    - `setNews()`: Yeni haber yayınlar

### 2. Observer Interface
- **[Channel](Channel.java)**
  - Tüm observer'ların uygulaması gereken arayüz
  - `update()` metodunu tanımlar

### 3. Concrete Observers
- **[NewsChannel](NewsChannel.java)**
  - TV kanallarını temsil eder
  - Haberleri ekranda gösterir

- **[EmailSubscriber](EmailSubscriber.java)**
  - Email abonelerini temsil eder
  - Haberleri email olarak gönderir

- **[MobileAppSubscriber](MobileAppSubscriber.java)**
  - Mobil uygulama kullanıcılarını temsil eder
  - Push notification gönderir

### 4. Demo
- **[ObserverDemo](ObserverDemo.java)**
  - Sistemin nasıl çalıştığını gösteren örnek sınıf

## Kod Örnekleri

### Observer Ekleme ve Haber Yayınlama
```java
NewsAgency newsAgency = new NewsAgency();
NewsChannel cnn = new NewsChannel("CNN");
EmailSubscriber user = new EmailSubscriber("user@example.com");

// Observer'ları ekle
newsAgency.addObserver(cnn);
newsAgency.addObserver(user);

// Yeni haber yayınla
newsAgency.setNews("Önemli gelişme!");
```

## UML Sınıf Diyagramı
```
+-------------+     +------------+
| NewsAgency  |     |  Channel   |
+-------------+     +------------+
| -observers  |     | +update()  |
| -news       |     +------------+
+-------------+           ▲
| +addObserver|           |
| +removeObs. |     +-----+-----+
| +setNews()  |     |     |     |
+-------------+     |     |     |
                   |     |     |
        +---------+  +---+---+  +----------+
        |NewsChannel| |Email  |  |MobileApp |
        +-----------+ |Sub.   |  |Subscriber|
        | -name     | +-------+  +----------+
        +-----------+
```

## Observer Pattern'ın Avantajları

1. **Loose Coupling**: Subject ve Observer'lar arasında gevşek bağlantı
2. **Broadcast İletişim**: Tek kaynaktan çoklu hedefe iletişim
3. **Dinamik İlişkiler**: Runtime'da Observer eklenip çıkarılabilir
4. **Açık/Kapalı Prensibi**: Yeni Observer türleri kolayca eklenebilir

## Gerçek Hayat Uygulamaları

- Haber Dağıtım Sistemleri
- Sosyal Medya Bildirimleri
- Event Management Sistemleri
- Stok Takip Sistemleri
- Sensör Ağları

## Nasıl Genişletilebilir?

1. **Kategori Bazlı Abonelik**
```java
public class CategoryBasedNewsAgency extends NewsAgency {
    private Map<String, List<Channel>> categorySubscribers;
    
    public void setNews(String news, String category) {
        // Sadece ilgili kategoriye abone olanları bilgilendir
        List<Channel> subscribers = categorySubscribers.get(category);
        for (Channel channel : subscribers) {
            channel.update(news);
        }
    }
}
```

2. **Öncelikli Bildirim**
```java
public class PriorityChannel implements Channel {
    private int priority;
    
    @Override
    public void update(String news) {
        if (priority > 5) {
            // Acil bildirim gönder
        } else {
            // Normal bildirim gönder
        }
    }
}
```

## En İyi Uygulama Önerileri

1. Observer'ları memory leak'lerden kaçınmak için düzgün yönetin
2. Çok sayıda Observer olduğunda performansı göz önünde bulundurun
3. Update metodunda ağır işlemlerden kaçının
4. Exception handling mekanizması ekleyin
5. Thread-safe implementasyon yapın

## Güvenlik Kontrol Listesi

- [ ] Observer ekleme/çıkarma yetkisi kontrolü
- [ ] Bildirim içeriği güvenliği
- [ ] Rate limiting
- [ ] Döngüsel bağımlılık kontrolü
- [ ] Resource leak kontrolü
