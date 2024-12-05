# Memento Design Pattern - Banka İşlemleri Örneği

Bu proje, Memento tasarım deseninin bir banka hesabı işlem geçmişi üzerinden uygulanmasını göstermektedir. Bu örnekte, banka hesap işlemlerinin kaydedilmesi ve gerektiğinde geri alınması işlemleri ele alınmıştır.

## Proje Yapısı

### 1. Originator
- **[BankAccount](BankAccount.java)**
  - Banka hesabını temsil eden sınıf
  - Hesap bakiyesi ve işlem geçmişini yönetir
  - Temel işlemler:
    - `deposit(double amount)`: Para yatırma
    - `withdraw(double amount)`: Para çekme
    - `save()`: Mevcut durumu memento olarak kaydeder
    - `restore(AccountMemento memento)`: Önceki durumu geri yükler

### 2. Memento
- **[AccountMemento](AccountMemento.java)**
  - Hesap durumunu saklayan sınıf
  - Bakiye ve işlem zamanı bilgilerini tutar
  - Immutable yapıdadır
  - Özellikler:
    - `balance`: Hesap bakiyesi
    - `timestamp`: İşlem zamanı
    - `description`: İşlem açıklaması

### 3. Caretaker
- **[TransactionManager](TransactionManager.java)**
  - İşlem geçmişini yöneten sınıf
  - Geri alma ve ileri alma işlemlerini sağlar
  - Temel işlemler:
    - `saveState(AccountMemento memento)`: Yeni durumu kaydeder
    - `undo()`: Son işlemi geri alır
    - `redo()`: Geri alınan son işlemi tekrar uygular
    - `getHistory()`: Tüm işlem geçmişini gösterir

### 4. Demo
- **[TransactionDemo](TransactionDemo.java)**
  - Banka hesabı işlemlerini ve geri alma/ileri alma özelliklerini test eder
  - Örnek senaryoları gösterir

## Kod Örnekleri

### Banka Hesabı İşlemleri
```java
BankAccount account = new BankAccount(1000); // Başlangıç bakiyesi
TransactionManager manager = new TransactionManager();

// Para yatırma
account.deposit(500);
manager.saveState(account.save());

// Para çekme
account.withdraw(200);
manager.saveState(account.save());

// Son işlemi geri alma
account.restore(manager.undo());

// İşlemi tekrar uygulama
account.restore(manager.redo());
```

## UML Sınıf Diyagramı
```
+-------------+     +----------------+     +------------------+
| BankAccount |     | AccountMemento |     | TransactionManager|
+-------------+     +----------------+     +------------------+
| -balance    |     | -balance       |     | -mementos       |
| -lastOp     |     | -timestamp     |     | -current        |
+-------------+     | -description   |     +------------------+
| +deposit()  |     +----------------+     | +saveState()    |
| +withdraw() |     | +getBalance()  |     | +undo()        |
| +save()     |     | +getTimestamp()|     | +redo()        |
| +restore()  |     | +getDescription|     | +getHistory()  |
+-------------+     +----------------+     +------------------+
```

## Pattern'ın Bu Uygulamadaki Avantajları

1. **İşlem Güvenliği**: Tüm işlemler geri alınabilir
2. **Denetim İzi**: Tüm işlemler kaydedilir ve izlenebilir
3. **Durum Yönetimi**: Hesap durumu güvenli bir şekilde yönetilir
4. **Hata Düzeltme**: Hatalı işlemler kolayca geri alınabilir

## Gerçek Hayat Uygulamaları

- Bankacılık Sistemleri
- Finansal İşlem Sistemleri
- Muhasebe Yazılımları
- E-ticaret Sipariş İşlemleri
- Ödeme Sistemleri

## Nasıl Genişletilebilir?

1. **İşlem Limiti Ekleme**
```java
public class LimitedBankAccount extends BankAccount {
    private double dailyLimit;
    private double usedLimit;
    
    @Override
    public void withdraw(double amount) {
        if (usedLimit + amount > dailyLimit) {
            throw new LimitExceededException();
        }
        super.withdraw(amount);
        usedLimit += amount;
    }
}
```

2. **İşlem Bildirimleri**
```java
public class NotificationDecorator extends TransactionManager {
    @Override
    public void saveState(AccountMemento memento) {
        super.saveState(memento);
        sendNotification("İşlem gerçekleştirildi: " + 
                        memento.getDescription());
    }
    
    private void sendNotification(String message) {
        // SMS, email veya push notification gönderimi
    }
}
```

3. **İşlem Kategorileri**
```java
public enum TransactionCategory {
    DEPOSIT, WITHDRAWAL, TRANSFER, PAYMENT
}

public class CategorizedAccountMemento extends AccountMemento {
    private TransactionCategory category;
    
    public CategorizedAccountMemento(double balance, 
                                   String description,
                                   TransactionCategory category) {
        super(balance, description);
        this.category = category;
    }
}
```
