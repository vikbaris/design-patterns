# Memento Design Pattern - Text Editor Örneği

Bu proje, Memento tasarım deseninin bir metin editörü üzerinden uygulanmasını göstermektedir. Memento Pattern, bir nesnenin önceki durumlarını saklamak ve gerektiğinde bu durumlara geri dönmek için kullanılır.

## Proje Yapısı

### 1. Originator
- **[TextEditor](TextEditor.java)**
  - Metin editörünü temsil eden sınıf
  - İçeriği yönetir ve memento nesneleri oluşturur
  - Memento'dan durumu geri yükleyebilir
  - Temel işlemler:
    - `write(String text)`: Yeni metin ekler
    - `save()`: Mevcut durumu memento olarak kaydeder
    - `restore(TextEditorMemento memento)`: Önceki durumu geri yükler

### 2. Memento
- **[TextEditorMemento](TextEditorMemento.java)**
  - Editörün durumunu saklayan sınıf
  - İçerik ve zaman damgası bilgilerini tutar
  - Immutable (değiştirilemez) yapıdadır

### 3. Caretaker
- **[History](History.java)**
  - Memento nesnelerini yöneten sınıf
  - Geri alma ve ileri alma işlemlerini sağlar
  - Temel işlemler:
    - `push(TextEditorMemento memento)`: Yeni durumu kaydeder
    - `undo()`: Son duruma geri döner
    - `redo()`: İptal edilen son değişikliği tekrar uygular

### 4. Demo
- **[MementoDemo](MementoDemo.java)**
  - Metin editörü ve geri alma/ileri alma işlemlerini test eder
  - Örnek kullanım senaryolarını gösterir

## Kod Örnekleri

### Metin Editörü Kullanımı
```java
TextEditor editor = new TextEditor();
History history = new History();

// Metin ekleme ve kaydetme
editor.write("İlk metin");
history.push(editor.save());

editor.write("İkinci metin");
history.push(editor.save());

// Geri alma
editor.restore(history.undo());

// İleri alma
editor.restore(history.redo());
```

## UML Sınıf Diyagramı
```
+-------------+     +------------------+     +-----------------+
| TextEditor  |     | TextEditorMemento|     |    History     |
+-------------+     +------------------+     +-----------------+
| -content    |     | -content         |     | -mementos      |
+-------------+     | -timestamp       |     | -current       |
| +write()    |     +------------------+     +-----------------+
| +save()     |     | +getContent()    |     | +push()        |
| +restore()  |     | +getTimestamp()  |     | +undo()        |
+-------------+     +------------------+     | +redo()        |
       ▲                                    +-----------------+
       |                    ▲                        |
       +--------------------+------------------------+
```

## Memento Pattern'ın Avantajları

1. **Kapsülleme**: Durum bilgisi originator dışında açığa çıkmaz
2. **Geri Alınabilirlik**: Önceki durumlara kolayca dönülebilir
3. **Basit Yedekleme**: Nesnelerin durumları kolayca yedeklenebilir
4. **Single Responsibility**: Her sınıf tek bir sorumluluğa sahiptir

## Gerçek Hayat Uygulamaları

- Metin Editörleri
- Grafik Tasarım Programları
- Oyun Kayıt Sistemleri
- Veritabanı İşlem Yönetimi
- Form Düzenleyiciler

## Nasıl Genişletilebilir?

1. **Otomatik Kayıt**
```java
public class AutoSaveTextEditor extends TextEditor {
    private History history;
    
    public void autoSave() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                history.push(save());
            }
        }, 0, 5000); // Her 5 saniyede bir kaydet
    }
}
```

2. **Çoklu Geri Alma Limiti**
```java
public class LimitedHistory extends History {
    private int maxSize;
    
    public LimitedHistory(int maxSize) {
        this.maxSize = maxSize;
    }
    
    @Override
    public void push(TextEditorMemento memento) {
        if (mementos.size() >= maxSize) {
            mementos.removeFirst();
        }
        super.push(memento);
    }
}
```
