# Ödeme Sistemi - State Pattern Örneği

Bu projede, State (Durum) tasarım desenini kullanarak bir ödeme sisteminin farklı durumlarını yönetiyoruz.

## Ödeme Durumları

1. **INITIATED (Başlatıldı)**
   - Başlangıç durumu
   - Sadece processPayment() işlemi yapılabilir
   - Diğer işlemler hata verir

2. **PENDING (Beklemede)**
   - Ödeme işleme alındığında geçilen durum
   - approvePayment() veya declinePayment() işlemleri yapılabilir
   - Tekrar processPayment() yapılamaz

3. **APPROVED (Onaylandı)**
   - Ödeme başarıyla tamamlandığında geçilen durum
   - Sadece refundPayment() işlemi yapılabilir
   - Diğer işlemler hata verir

4. **DECLINED (Reddedildi)**
   - Ödeme reddedildiğinde geçilen durum
   - Tekrar processPayment() ile ödeme denenebilir
   - Diğer işlemler hata verir

5. **REFUNDED (İade Edildi)**
   - Onaylanmış ödeme iade edildiğinde geçilen durum
   - Hiçbir işlem yapılamaz
   - Tüm işlemler hata verir

## Durum Geçişleri

```
INITIATED --[processPayment()]--> PENDING
PENDING --[approvePayment()]--> APPROVED
PENDING --[declinePayment()]--> DECLINED
APPROVED --[refundPayment()]--> REFUNDED
DECLINED --[processPayment()]--> PENDING
```

## Kod Yapısı

- **PaymentState**: Tüm durum sınıflarının uyguladığı arayüz
- **InitiatedState**: Başlangıç durumu
- **PendingState**: Bekleyen ödeme durumu
- **ApprovedState**: Onaylanmış ödeme durumu
- **DeclinedState**: Reddedilmiş ödeme durumu
- **RefundedState**: İade edilmiş ödeme durumu
- **Payment**: Context sınıfı, ödeme bilgilerini ve mevcut durumu tutar
- **PaymentDemo**: Örnek kullanımları gösteren demo sınıfı

## Kullanım Örneği

```java
// Başarılı ödeme senaryosu
Payment payment = new Payment("12345", 100.0);  // INITIATED
payment.processPayment();                       // -> PENDING
payment.approvePayment();                       // -> APPROVED
payment.refundPayment();                        // -> REFUNDED

// Başarısız ödeme senaryosu
Payment payment = new Payment("67890", 200.0);  // INITIATED
payment.processPayment();                       // -> PENDING
payment.declinePayment();                       // -> DECLINED
payment.processPayment();                       // -> PENDING (tekrar deneme)
```

## State Pattern'in Avantajları

1. **Temiz Kod**
   - Karmaşık if-else yapıları yerine her durum kendi mantığını yönetir
   - Single Responsibility Principle'a uygun
   - Kod okunabilirliği yüksek

2. **Kolay Genişletilebilirlik**
   - Yeni durumlar kolayca eklenebilir
   - Mevcut kodu değiştirmeden sistem genişletilebilir

3. **Güvenli Durum Geçişleri**
   - Her durum, hangi duruma geçebileceğini kendisi belirler
   - Geçersiz durum geçişleri engellenir
   - İş kuralları ilgili durum sınıfında kapsüllenir

4. **Bakım Kolaylığı**
   - Her durum ayrı bir sınıfta olduğu için bakımı kolay
   - Değişiklikler sadece ilgili durumu etkiler
   - Test edilebilirlik yüksek
