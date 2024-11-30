# Command Pattern - Metin Editörü Örneği

Bu örnek, Command tasarım deseninin metin editörü uygulamasında nasıl kullanılabileceğini göstermektedir. Uygulama, metin ekleme, silme ve değiştirme işlemlerini destekler ve her işlem için geri alma (undo) ve yeniden yapma (redo) özelliklerini içerir.

## Tasarım Yapısı

### 1. Receiver (TextEditor)
- Temel metin işleme operasyonlarını gerçekleştirir
- StringBuilder kullanarak metin manipülasyonunu yönetir
- insert(), delete() ve replace() gibi temel operasyonları sağlar

### 2. Command Interface (EditorCommand)
- execute(): Komutu çalıştırır
- undo(): Komutu geri alır

### 3. Concrete Commands
- **InsertCommand**: Metin ekleme işlemi
- **DeleteCommand**: Metin silme işlemi
- **ReplaceCommand**: Metin değiştirme işlemi

### 4. Invoker (EditorInvoker)
- Komutları yönetir ve çalıştırır
- Geri alma ve yeniden yapma işlemlerini kontrol eder
- İki Stack kullanır:
  * undoStack: Geri alınabilecek komutları tutar
  * redoStack: Yeniden yapılabilecek komutları tutar

## Özellikler

1. **Geri Alma/İleri Alma**
   - Her komut kendi geri alma mantığını içerir
   - Sınırsız geri alma ve ileri alma desteği
   - Stack veri yapısı ile etkin komut geçmişi yönetimi

2. **Thread-Safe Yapı**
   - Java'nın yerleşik Stack sınıfı kullanılarak thread güvenliği sağlanır
   - Çoklu iş parçacığı ortamlarında güvenli çalışır

3. **Modüler Tasarım**
   - Her komut bağımsız bir sınıf olarak implement edilmiştir
   - Yeni komutlar kolayca eklenebilir
   - Loose coupling prensibi uygulanmıştır

## Kullanım Örneği

```java
TextEditor editor = new TextEditor();
EditorInvoker invoker = new EditorInvoker();

// Metin ekleme
EditorCommand insertCommand = new InsertCommand(editor, "Merhaba ", 0);
invoker.executeCommand(insertCommand);

// Metin değiştirme
EditorCommand replaceCommand = new ReplaceCommand(editor, 0, 7, "Selam");
invoker.executeCommand(replaceCommand);

// Son işlemi geri al
invoker.undo();

// Geri alınan işlemi yeniden yap
invoker.redo();
```

## Avantajları

1. **Esnek İşlem Yönetimi**
   - İşlemler nesneler olarak temsil edilir
   - İşlem geçmişi kolayca yönetilebilir
   - İşlemler sıraya konabilir ve gruplandırılabilir

2. **Kolay Genişletilebilirlik**
   - Yeni komutlar eklemek için mevcut kodu değiştirmek gerekmez
   - Open/Closed prensibine uygun tasarım

3. **Güvenli İşlem Takibi**
   - Her işlem kayıt altına alınır
   - Hata durumunda geri alma yapılabilir
   - Thread-safe yapı sayesinde çoklu iş parçacığı desteği

## Kullanım Alanları

- Metin editörleri
- Grafik tasarım uygulamaları
- Oyun sistemleri
- İş akışı yönetim sistemleri
- Veritabanı transaction yönetimi
