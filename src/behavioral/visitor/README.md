# Visitor Design Pattern Example

Bu proje, Visitor tasarım deseninin Java programlama dili kullanılarak gerçekleştirilmiş bir örneğini içerir. Örnek, bir alışveriş sepeti senaryosu üzerinden Visitor Pattern'ın nasıl uygulanacağını göstermektedir.

## Visitor Pattern Nedir?

Visitor Pattern, nesne yapısındaki elemanlara yeni işlevler eklemek için kullanılan davranışsal (behavioral) bir tasarım desenidir. Bu desen, mevcut sınıfları değiştirmeden yeni operasyonlar eklememizi sağlar.

## Proje Mimarisi

### Temel Bileşenler

1. **Item (Element Interface)**
   - Ziyaret edilebilecek öğelerin arayüzünü tanımlar
   - `accept()` metodunu içerir
   - Tüm concrete element sınıfları bu arayüzü uygular

2. **Concrete Elements**
   - `Book`: Kitap öğelerini temsil eder (fiyat ve ISBN numarası)
   - `Fruit`: Meyve öğelerini temsil eder (kg başına fiyat, ağırlık ve isim)
   - Her biri `Item` arayüzünü uygular

3. **ShoppingCartVisitor (Visitor Interface)**
   - Ziyaretçi sınıflarının uygulayacağı metotları tanımlar
   - Her concrete element için bir `visit()` metodu içerir

4. **ShoppingCartVisitorImpl (Concrete Visitor)**
   - `ShoppingCartVisitor` arayüzünü uygular
   - Her öğe türü için özel fiyatlandırma mantığını içerir

### UML Sınıf Diyagramı

```
+----------------+     +----------------------+
|     Item       |     |   ShoppingCartVisitor|
+----------------+     +----------------------+
| +accept()      |     | +visit(Book)        |
+----------------+     | +visit(Fruit)       |
       ▲               +----------------------+
       |                         ▲
       |                         |
+----------------+     +----------------------+
|     Book       |     |ShoppingCartVisitorImpl|
+----------------+     +----------------------+
| -price         |     | +visit(Book)        |
| -isbnNumber    |     | +visit(Fruit)       |
+----------------+     +----------------------+

+----------------+
|     Fruit      |
+----------------+
| -pricePerKg    |
| -weight        |
| -name          |
+----------------+
```

## Çalışma Mantığı

1. Her concrete element (`Book` ve `Fruit`), `Item` arayüzünü uygular ve `accept()` metodunu içerir.
2. `accept()` metodu, ziyaretçi nesnesini parametre olarak alır.
3. Ziyaretçi nesnesi (`ShoppingCartVisitorImpl`), her öğe türü için özel işlem mantığını içerir.
4. Yeni bir işlem eklemek için sadece yeni bir ziyaretçi sınıfı oluşturmak yeterlidir.

## Kullanım Örneği

```java
Item[] items = new Item[]{
    new Book(20, "1234"),
    new Book(100, "5678"),
    new Fruit(10, 2, "Banana"),
    new Fruit(5, 5, "Apple")
};

ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
int totalCost = 0;
for (Item item : items) {
    totalCost += item.accept(visitor);
}
```

## Avantajları

1. **Açık/Kapalı Prensibi**: Mevcut kodu değiştirmeden yeni işlevler ekleyebilirsiniz.
2. **Tek Sorumluluk**: Her ziyaretçi sınıfı belirli bir işlemi gerçekleştirir.
3. **Esneklik**: Farklı öğe türleri için özel işlemler tanımlayabilirsiniz.

## Dezavantajları

1. Her yeni element eklendiğinde, tüm visitor sınıflarına yeni metotlar eklenmesi gerekir.
2. Element hiyerarşisi değiştiğinde, visitor arayüzünün de güncellenmesi gerekebilir.

## Ne Zaman Kullanılmalı?

- Nesne yapısı sabit ancak sık sık yeni operasyonlar eklenmesi gerekiyorsa
- İlgili operasyonların nesne sınıflarında olması uygun değilse
- Nesne yapısındaki sınıflar farklı arayüzler uyguluyor ve bu sınıflar üzerinde ortak operasyonlar gerçekleştirmek gerekiyorsa
