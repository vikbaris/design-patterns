# Command Design Pattern

Command (Komut) tasarım deseni, bir isteği nesne olarak kapsülleyen davranışsal bir tasarım desenidir. Bu sayede istekleri parametre olarak geçebilir, sıraya koyabilir, geri alabiliriz.

## Kullanım Amacı
- İstekleri nesneler olarak temsil etmek
- İstek gönderen ve işleyen nesneleri birbirinden ayırmak
- İstekleri sıraya koymak, geri almak veya kaydetmek
- İşlemleri geri alma (undo) özelliği eklemek

## Örnek Senaryo
Bu örnekte, bir akıllı ev otomasyon sistemi oluşturuyoruz:

1. Cihazlar (Receivers):
   - Işıklar
   - Televizyon
   - Müzik Sistemi

2. Komutlar:
   - Aç/Kapat komutları
   - Ses seviyesi komutları
   - Tüm cihazları kapatma komutu

3. Uzaktan Kumanda (Invoker):
   - Komutları çalıştıran ve geri alan kontrol birimi

## Pattern Yapısı
- Command: Komutu tanımlayan arayüz
- ConcreteCommand: Komut arayüzünü uygulayan sınıflar
- Receiver: Komutun uygulandığı nesne
- Invoker: Komutu çalıştıran nesne
- Client: Komut nesnelerini oluşturan ve Invoker'a atayan nesne
