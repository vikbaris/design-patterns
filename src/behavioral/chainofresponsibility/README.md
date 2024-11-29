# Chain of Responsibility Pattern - ATM Para Çekme Örneği

Bu proje, Chain of Responsibility (Sorumluluk Zinciri) tasarım deseninin ATM para çekme senaryosu üzerinden uygulamasını göstermektedir.

## Chain of Responsibility Nedir?

Chain of Responsibility, bir isteği işlemek için nesneler zinciri oluşturmamızı sağlayan davranışsal bir tasarım desenidir. Bu desen sayesinde:

- Bir isteği gönderen ile işleyen nesneler arasındaki bağımlılık azalır
- Her bir işleyici nesne bağımsız olarak isteği işleme veya bir sonraki işleyiciye iletme kararı verebilir
- Yeni işleyiciler sisteme kolayca eklenebilir (Open/Closed Principle)

## Proje Yapısı

Projede yer alan sınıflar ve görevleri:

1. `Currency.java`: Para miktarını temsil eden basit bir sınıf
   - `amount`: Para miktarı
   - `getAmount()`: Para miktarını döndüren getter metodu

2. `MoneyDispenser.java`: Soyut temel sınıf
   - `nextDispenser`: Zincirdeki bir sonraki işleyici
   - `setNextDispenser()`: Sonraki işleyiciyi ayarlayan metod
   - `dispense()`: Para çekme işlemini gerçekleştiren abstract metod

3. Concrete Dispenser Sınıfları:
   - `Dispenser500.java`: 500 TL banknotları işler
   - `Dispenser200.java`: 200 TL banknotları işler
   - `Dispenser100.java`: 100 TL banknotları işler
   - `Dispenser50.java`: 50 TL banknotları işler

4. `ATMDemo.java`: Test sınıfı

## Çalışma Mantığı

1. İlk olarak dispenser nesneleri oluşturulur ve zincir şu şekilde kurulur:
   500TL -> 200TL -> 100TL -> 50TL

2. Para çekme isteği ilk dispenser'a (500TL) iletilir

3. Her dispenser şu adımları izler:
   - Eğer miktar kendi banknot değerinden büyük veya eşitse:
     * Mümkün olan maksimum sayıda banknot verilir
     * Kalan miktar varsa ve sonraki dispenser mevcutsa, istek sonraki dispensera iletilir
   - Eğer miktar kendi banknot değerinden küçükse:
     * İstek direkt olarak sonraki dispensera iletilir

## Örnek Senaryo

Para çekme isteği: 1750 TL

1. 500'lük dispenser:
   - 3 adet 500 TL verir (1500 TL)
   - Kalan: 250 TL

2. 200'lük dispenser:
   - 1 adet 200 TL verir
   - Kalan: 50 TL

3. 100'lük dispenser:
   - Miktar 100'den küçük, sonraki dispensera geçer

4. 50'lik dispenser:
   - 1 adet 50 TL verir
   - İşlem tamamlanır

## Kullanım

Projeyi derlemek ve çalıştırmak için:

```bash
# Derleme
javac behavioral/chainofresponsibility/*.java

# Çalıştırma
java behavioral.chainofresponsibility.ATMDemo
```

## Chain of Responsibility'nin Avantajları

1. **Loose Coupling**: İstemci ve işleyici nesneler arasındaki bağımlılık azalır
2. **Single Responsibility**: Her işleyici sadece kendi mantığından sorumludur
3. **Esneklik**: Yeni işleyiciler kolayca eklenebilir veya çıkarılabilir
4. **İsteğin Dinamik İşlenmesi**: İşleyici zinciri runtime'da değiştirilebilir
