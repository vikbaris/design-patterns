# Template Method Pattern - Bankacılık İşlemleri Örneği

Bu proje, Template Method tasarım deseninin bir bankacılık sistemi üzerinden uygulanmasını göstermektedir. Her banka işlemi (para çekme, yatırma, transfer) benzer adımlardan geçer ancak her birinin kendi özel uygulaması vardır.

## Proje Yapısı

### 1. Abstract Class (Template)
- **[BankingTransaction](BankingTransaction.java)**
  - Banka işlemlerinin temel şablonunu tanımlayan soyut sınıf
  - Template method: `executeTransaction()`
  - İşlem adımları:
    1. Güvenlik kontrolü
    2. Hesap kontrolü
    3. İşlem limiti kontrolü
    4. Ana işlem
    5. Kayıt tutma
    6. Bildirim gönderme

### 2. Concrete Classes
- **[WithdrawTransaction](WithdrawTransaction.java)**
  - Para çekme işlemi implementasyonu
  - Günlük limit kontrolü
  - Bakiye kontrolü

- **[DepositTransaction](DepositTransaction.java)**
  - Para yatırma işlemi implementasyonu
  - Şüpheli işlem kontrolü
  - Hesap aktiflik kontrolü

- **[TransferTransaction](TransferTransaction.java)**
  - Para transfer işlemi implementasyonu
  - Çift taraflı hesap kontrolü
  - Transfer limit kontrolü
  - Çift taraflı bildirim

### 3. Demo
- **[BankingDemo](BankingDemo.java)**
  - Farklı banka işlemlerini test eden demo sınıfı

## İşlem Akışı

Her banka işlemi şu adımlardan geçer:

1. **Güvenlik Kontrolü**
   - Kimlik doğrulama
   - İşlem şifresi kontrolü
   - IP kontrolü
   - Şüpheli işlem kontrolü

2. **Hesap Kontrolü**
   - Hesap varlığı kontrolü
   - Hesap durumu kontrolü
   - Bakiye kontrolü

3. **Limit Kontrolü**
   - Günlük işlem limiti
   - İşlem tutarı limiti
   - Şüpheli işlem limiti

4. **İşlem Gerçekleştirme**
   - Ana işlem mantığı
   - Bakiye güncelleme
   - İşlem onayı

5. **Kayıt ve Bildirim**
   - İşlem kaydı oluşturma
   - Kullanıcı bildirimi
   - Raporlama

## Kod Örnekleri

### İşlem Oluşturma ve Çalıştırma
```java
// Para çekme işlemi
BankingTransaction withdraw = new WithdrawTransaction("12345", 1000.0);
withdraw.executeTransaction();

// Para yatırma işlemi
BankingTransaction deposit = new DepositTransaction("12345", 2000.0);
deposit.executeTransaction();

// Para transfer işlemi
BankingTransaction transfer = new TransferTransaction("12345", "67890", 3000.0);
transfer.executeTransaction();
```

## Güvenlik Önlemleri

1. **Para Çekme**
   - Günlük limit: 5.000 TL
   - Kimlik/Kart kontrolü
   - PIN doğrulama

2. **Para Yatırma**
   - Şüpheli işlem limiti: 50.000 TL
   - Hesap aktiflik kontrolü
   - Kara para aklama kontrolü

3. **Para Transferi**
   - Transfer limiti: 10.000 TL
   - Alıcı hesap kontrolü
   - IP ve işlem şifresi kontrolü

## Genişletme Örnekleri

1. **Uluslararası Transfer**
```java
public class InternationalTransfer extends BankingTransaction {
    private String swiftCode;
    private String iban;
    
    @Override
    protected void validateSecurity() {
        // SWIFT kodu doğrulama
        // Uluslararası kara liste kontrolü
    }
    
    @Override
    protected void checkTransactionLimit() {
        // Döviz kontrolü
        // Ülke bazlı limit kontrolü
    }
}
```

2. **Otomatik Ödeme**
```java
public class AutoPayment extends BankingTransaction {
    private String billType;
    private String subscriberId;
    
    @Override
    protected void checkAccount() {
        // Otomatik ödeme talimatı kontrolü
        // Bakiye yeterlilik kontrolü
    }
    
    @Override
    protected void performTransaction() {
        // Fatura sorgulama
        // Ödeme gerçekleştirme
    }
}
```

## En İyi Uygulama Önerileri

1. Her işlem türü için ayrı limit tanımlayın
2. İşlem kayıtlarını detaylı tutun
3. Kullanıcı bildirimlerini özelleştirin
4. Güvenlik kontrollerini katmanlı yapın
5. Hata durumlarını düzgün yönetin
6. İşlem durumlarını loglayın

## Güvenlik Kontrol Listesi

- [ ] İşlem limiti kontrolü
- [ ] Kullanıcı kimlik doğrulama
- [ ] IP adresi kontrolü
- [ ] Şüpheli işlem kontrolü
- [ ] Kara liste kontrolü
- [ ] İşlem şifresi doğrulama
- [ ] Hesap durumu kontrolü
- [ ] Bakiye kontrolü
