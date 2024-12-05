# Iterator Design Pattern - Müzik Çalar Örneği

Bu proje, Iterator tasarım deseninin bir müzik çalar uygulaması üzerinden uygulanmasını göstermektedir. Iterator Pattern, bir koleksiyonun elemanlarına sıralı erişim sağlayan ve koleksiyonun iç yapısını gizleyen bir davranışsal tasarım desenidir.

## Iterator Pattern Nedir?

Iterator Pattern, bir koleksiyonun elemanlarına, koleksiyonun iç yapısını bilmeden erişmemizi sağlayan bir tasarım desenidir. Bu desen sayesinde:
- Koleksiyon üzerinde farklı gezinme stratejileri uygulayabiliriz
- Koleksiyonun iç yapısını değiştirmeden yeni gezinme yöntemleri ekleyebiliriz
- Koleksiyona erişim mantığını koleksiyondan ayırabiliriz

## Proje Yapısı

### 1. Temel Sınıflar
- **[Song](Song.java)**
  - Şarkı bilgilerini tutan sınıf (ad, sanatçı, tür, süre)

- **[Playlist](Playlist.java)**
  - Şarkı koleksiyonunu yöneten sınıf
  - Iterator oluşturma sorumluluğunu üstlenir
  - Sıralı ve karışık çalma modlarını destekler

### 2. Iterator Interface
- **[MusicIterator](MusicIterator.java)**
  - Tüm iterator'ların uygulaması gereken arayüz
  - Temel metodlar:
    - `hasNext()`: Sonraki eleman var mı?
    - `next()`: Sonraki elemanı getir
    - `reset()`: Başa dön
    - `hasPrevious()`: Önceki eleman var mı? (opsiyonel)
    - `previous()`: Önceki elemanı getir (opsiyonel)

### 3. Concrete Iterators
- **[SequentialIterator](SequentialIterator.java)**
  - Sıralı gezinme sağlar
  - İleri-geri gezinmeyi destekler

- **[ShuffleIterator](ShuffleIterator.java)**
  - Karışık gezinme sağlar
  - Her reset'te yeni bir karışık sıra oluşturur

- **[GenreFilterIterator](GenreFilterIterator.java)**
  - Belirli bir türdeki şarkıları filtreler
  - Sadece istenen türdeki şarkılar üzerinde gezinir

### 4. Demo
- **[IteratorDemo](IteratorDemo.java)**
  - Farklı iterator türlerinin kullanımını gösterir

## Kod Örnekleri

### 1. Temel Kullanım
```java
Playlist playlist = new Playlist("Favoriler");
playlist.addSong(new Song("Şarkı 1", "Sanatçı 1", "Rock", 180));
playlist.addSong(new Song("Şarkı 2", "Sanatçı 2", "Pop", 240));

MusicIterator iterator = playlist.getIterator();
while (iterator.hasNext()) {
    Song song = iterator.next();
    System.out.println(song);
}
```

### 2. Karışık Çalma
```java
playlist.setShuffle(true);
MusicIterator shuffleIterator = playlist.getIterator();
while (shuffleIterator.hasNext()) {
    System.out.println(shuffleIterator.next());
}
```

### 3. Tür Filtreleme
```java
GenreFilterIterator rockIterator = new GenreFilterIterator(songs, "Rock");
while (rockIterator.hasNext()) {
    System.out.println(rockIterator.next());
}
```

## Iterator Pattern'ın Avantajları

1. **Tek Sorumluluk Prensibi (SRP)**
   - Koleksiyon ve gezinme mantığı ayrılır
   - Her iterator kendi gezinme stratejisini uygular

2. **Açık/Kapalı Prensibi (OCP)**
   - Yeni iterator türleri kolayca eklenebilir
   - Mevcut kodu değiştirmeden yeni özellikler eklenebilir

3. **Soyutlama**
   - Koleksiyonun iç yapısı gizlenir
   - Kullanıcı sadece iterator arayüzünü bilmeli

4. **Esneklik**
   - Farklı gezinme stratejileri uygulanabilir
   - Çalışma zamanında strateji değiştirilebilir

## Gerçek Hayat Uygulamaları

1. **Müzik Çalarlar**
   - Sıralı çalma
   - Karışık çalma
   - Tür bazlı filtreleme

2. **Dosya Sistemleri**
   - Dizin gezinme
   - Dosya filtreleme

3. **Veri Tabanları**
   - Sorgu sonuçlarında gezinme
   - Sayfalama

4. **Sosyal Medya**
   - Feed gezinme
   - Filtreleme

## Nasıl Genişletilebilir?

1. **Yeni Iterator Türleri**
```java
public class ArtistFilterIterator implements MusicIterator {
    private String artist;
    // Artist bazlı filtreleme
}

public class DateRangeIterator implements MusicIterator {
    private Date startDate, endDate;
    // Tarih aralığına göre filtreleme
}
```

2. **İleri Özellikler**
```java
public interface AdvancedMusicIterator extends MusicIterator {
    void skipNext(int count);
    void skipPrevious(int count);
    void jumpTo(int index);
}
```

## En İyi Uygulama Önerileri

1. Iterator'ı koleksiyondan bağımsız tutun
2. Her iterator tek bir gezinme stratejisi uygulasın
3. Iterator'ın durumunu kontrol edin (hasNext())
4. Gerektiğinde birden fazla iterator türü destekleyin
5. Thread-safe implementasyonlar için dikkatli olun

## Güvenlik Kontrol Listesi

- [ ] Concurrent modification kontrolü
- [ ] Null pointer kontrolü
- [ ] Sınır kontrolü
- [ ] Exception handling
- [ ] İterator state yönetimi
