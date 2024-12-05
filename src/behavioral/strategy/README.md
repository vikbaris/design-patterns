# Strategy Design Pattern - Ödeme Sistemi Örneği

Bu proje, Strategy tasarım deseninin bir e-ticaret ödeme sistemi üzerinden uygulanmasını göstermektedir. Strategy Pattern, bir algoritma ailesi tanımlamamıza, her birini ayrı bir sınıfa koymamıza ve nesnelerini birbirinin yerine kullanılabilir hale getirmemize olanak tanır.

## Proje Yapısı

### 1. Strategy Interface
- **[PaymentStrategy](PaymentStrategy.java)**
  - Tüm ödeme stratejilerinin uygulaması gereken arayüz
  - `pay(int amount)`: Ödeme işlemini gerçekleştiren metot
  - `getPaymentMethod()`: Ödeme yöntemini döndüren metot

### 2. Concrete Strategies
- **[CreditCardPayment](CreditCardPayment.java)**
  - Kredi kartı ile ödeme stratejisi
  - Kart numarası, CVV ve son kullanma tarihi bilgilerini içerir
  - Kredi kartı ile ödeme işlemini simüle eder

- **[CryptoPayment](CryptoPayment.java)**
  - Kripto para ile ödeme stratejisi
  - Wallet adresi ve kripto para türü bilgilerini içerir
  - Kripto para ile ödeme işlemini simüle eder

### 3. Context
- **[ShoppingCart](ShoppingCart.java)**
  - Alışveriş sepetini temsil eden sınıf
  - Seçilen ödeme stratejisini kullanarak ödeme işlemini gerçekleştirir
  - Ödeme stratejisini dinamik olarak değiştirebilir

### 4. Demo
- **[StrategyDemo](StrategyDemo.java)**
  - Farklı ödeme stratejilerinin kullanımını gösteren örnek sınıf
  - Kredi kartı ve kripto para ödemelerini test eder

## Kod Örnekleri

### Ödeme Stratejisi Oluşturma
```java
// Kredi Kartı Ödemesi
PaymentStrategy creditCard = new CreditCardPayment(
    "1234-5678-9012-3456",
    "123",
    "12/2024"
);

// Kripto Para Ödemesi
PaymentStrategy crypto = new CryptoPayment(
    "0x742d35Cc6634C0532925a3b844Bc454e4438f44e",
    "ETH"
);
```

### Alışveriş Sepeti Kullanımı
```java
ShoppingCart cart = new ShoppingCart();

// Kredi kartı ile ödeme
cart.setPaymentStrategy(creditCard);
cart.checkout(100);

// Kripto para ile ödeme
cart.setPaymentStrategy(crypto);
cart.checkout(200);
```

## UML Sınıf Diyagramı
```
+-------------------+
|  PaymentStrategy  |
+-------------------+
| +pay(amount)      |
| +getPaymentMethod()|
+-------------------+
         ▲
         |
+------------------+
|                  |
+---------------+  +---------------+
|CreditCardPayment| |CryptoPayment |
+---------------+  +---------------+
|-cardNumber    |  |-walletAddress |
|-cvv           |  |-cryptoType    |
|-expiryDate    |  |               |
+---------------+  +---------------+
|+pay(amount)   |  |+pay(amount)   |
|+getPaymentMethod()|+getPaymentMethod()|
+---------------+  +---------------+

      +-------------+
      |ShoppingCart |
      +-------------+
      |-strategy    |
      +-------------+
      |+checkout()  |
      +-------------+
```

## Strategy Pattern'ın Avantajları

1. **Esneklik**: Yeni ödeme yöntemleri kolayca eklenebilir (Open/Closed Principle)
2. **Değiştirilebilirlik**: Ödeme stratejileri runtime'da değiştirilebilir
3. **Bakım Kolaylığı**: Her ödeme stratejisi kendi sınıfında izole edilmiştir
4. **Test Edilebilirlik**: Her strateji bağımsız olarak test edilebilir

## Gerçek Hayat Uygulamaları

- E-ticaret Sistemleri
- Ödeme İşlem Sistemleri
- Fiyatlandırma Stratejileri
- İndirim Hesaplama Sistemleri
- Teslimat Yönetim Sistemleri

## Nasıl Genişletilebilir?

Yeni bir ödeme yöntemi eklemek için:
1. `PaymentStrategy` interface'ini implement eden yeni bir sınıf oluşturun
2. `pay()` ve `getPaymentMethod()` metodlarını uygulayın
3. Yeni stratejiyi `ShoppingCart` üzerinde kullanın

Örnek:
```java
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    @Override
    public void pay(int amount) {
        // PayPal ödeme işlemleri
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}
```
