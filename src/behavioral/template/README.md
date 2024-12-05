# Template Method Design Pattern - Oyun Örneği

Bu proje, Template Method tasarım deseninin bir oyun sistemi üzerinden uygulanmasını göstermektedir. Template Method, bir algoritmanın iskeletini tanımlayan ve bazı adımların uygulanmasını alt sınıflara bırakan bir davranışsal tasarım desenidir.

## Template Method Pattern Nedir?

Template Method Pattern, bir işlemin temel yapısını abstract bir sınıfta tanımlayan ve değişken kısımları alt sınıflara bırakan bir tasarım desenidir. Bu desen "Hollywood Prensibi"ni uygular: "Bizi aramayın, biz sizi ararız."

## Proje Yapısı

### 1. Abstract Class (Template)
- **[Game](Game.java)**
  - Oyun şablonunu tanımlayan soyut sınıf
  - Template method: `play()`
  - Hook methods:
    - `initialize()`
    - `prepareGame()`
    - `startGame()`
    - `endGame()`

### 2. Concrete Classes
- **[ChessGame](ChessGame.java)**
  - Satranç oyunu implementasyonu
  - Tüm hook metodları kendi mantığıyla uygular

- **[FootballGame](FootballGame.java)**
  - Futbol maçı implementasyonu
  - Tüm hook metodları kendi mantığıyla uygular

### 3. Client
- **[TemplateDemo](TemplateDemo.java)**
  - Farklı oyun türlerini test eden demo sınıfı

## Kod Örnekleri

### Template Method Kullanımı
```java
// Abstract sınıfta template method tanımı
public abstract class Game {
    public final void play() {
        initialize();
        prepareGame();
        startGame();
        endGame();
    }
    
    protected abstract void initialize();
    protected abstract void prepareGame();
    protected abstract void startGame();
    protected abstract void endGame();
}

// Concrete sınıfta kullanımı
Game chess = new ChessGame();
chess.play();  // Tüm adımları sırasıyla çalıştırır
```

## UML Sınıf Diyagramı
```
+------------------+
|      Game        |
+------------------+
| +play()          |
| #initialize()    |
| #prepareGame()   |
| #startGame()     |
| #endGame()       |
+------------------+
         ▲
         |
+------------------+
|    ChessGame     |
+------------------+
| #initialize()    |
| #prepareGame()   |
| #startGame()     |
| #endGame()       |
+------------------+

+------------------+
|  FootballGame    |
+------------------+
| #initialize()    |
| #prepareGame()   |
| #startGame()     |
| #endGame()       |
+------------------+
```

## Template Method Pattern'ın Avantajları

1. **Kod Tekrarını Önleme**: Ortak kod tek bir yerde toplanır
2. **Genişletilebilirlik**: Yeni oyun türleri kolayca eklenebilir
3. **Kontrollü Genişleme**: Alt sınıflar sadece gerekli metodları override eder
4. **Tutarlı Yapı**: Tüm alt sınıflar aynı temel algoritmayı takip eder

## Gerçek Hayat Uygulamaları

- Oyun Motorları
- Belge İşleme Sistemleri
- Veri Madenciliği Algoritmaları
- Build Sistemleri
- Test Framework'leri

## Nasıl Genişletilebilir?

1. **Yeni Oyun Türü Ekleme**
```java
public class CardGame extends Game {
    @Override
    protected void initialize() {
        System.out.println("Kart oyunu başlatılıyor...");
    }
    
    @Override
    protected void prepareGame() {
        System.out.println("Kartlar karılıyor...");
    }
    
    // Diğer metodlar...
}
```

2. **Hook Method Ekleme**
```java
public abstract class Game {
    public final void play() {
        initialize();
        prepareGame();
        if (needsWarmup()) {
            warmup();
        }
        startGame();
        endGame();
    }
    
    // Opsiyonel hook method
    protected boolean needsWarmup() {
        return false;
    }
    
    protected void warmup() {
        // Varsayılan implementasyon
    }
}
```

3. **Oyun İstatistikleri**
```java
public abstract class Game {
    protected GameStats stats;
    
    public final void play() {
        stats = new GameStats();
        stats.startTime = System.currentTimeMillis();
        
        // Normal oyun akışı...
        
        stats.endTime = System.currentTimeMillis();
        saveStats();
    }
    
    protected abstract void saveStats();
}
```

## En İyi Uygulama Önerileri

1. Template method'u `final` olarak işaretleyin
2. Hook metodları `protected` yapın
3. Soyut sınıfta varsayılan implementasyonlar sağlayın
4. Dokümantasyonda hangi metodların override edilmesi gerektiğini belirtin
5. İsimlendirme kurallarına dikkat edin (örn: initialize, prepare, start, end gibi)
