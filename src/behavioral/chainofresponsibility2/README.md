# Chain of Responsibility Pattern - Destek Talebi Örneği

Bu proje, Chain of Responsibility (Sorumluluk Zinciri) tasarım deseninin teknik destek talebi senaryosu üzerinden uygulamasını göstermektedir.

## Senaryo

Bu örnekte, farklı seviyelerde teknik destek sağlayan bir sistem simüle edilmektedir:

1. Birinci Seviye Destek (Severity <= 3)
   - Basit yazılım güncellemeleri
   - Temel kullanıcı sorunları
   - Rutin bakım talepleri

2. İkinci Seviye Destek (3 < Severity <= 6)
   - Performans sorunları
   - Karmaşık yapılandırma değişiklikleri
   - Sistem optimizasyonları

3. Yönetici Seviye Destek (Severity > 6)
   - Kritik sistem arızaları
   - Güvenlik ihlalleri
   - Acil müdahale gerektiren durumlar

## Proje Yapısı

1. `SupportHandler.java`: Soyut temel sınıf
   - `nextHandler`: Zincirdeki sonraki handler
   - `setNextHandler()`: Zinciri oluşturmak için kullanılan metod
   - `handleRequest()`: Talebi işleyen soyut metod

2. `SupportTicket.java`: Destek talebi sınıfı
   - `severity`: Talebin önem derecesi (1-10 arası)
   - `description`: Talep açıklaması

3. Handler Sınıfları:
   - `FirstLevelSupportHandler.java`: Düşük önem seviyeli talepleri işler
   - `SecondLevelSupportHandler.java`: Orta önem seviyeli talepleri işler
   - `ManagerSupportHandler.java`: Yüksek önem seviyeli talepleri işler

4. `ChainOfResponsibilityDemo.java`: Test sınıfı

## Çalışma Mantığı

1. Destek talebi ilk seviye desteğe iletilir
2. Her seviye kendi çözebileceği talepleri işler
3. Çözemediği talepleri bir üst seviyeye iletir
4. En üst seviye (Yönetici) de çözemezse talep çözümsüz kalır

## Kullanım

```bash
# Derleme
javac behavioral/chainofresponsibility2/*.java

# Çalıştırma
java behavioral.chainofresponsibility2.ChainOfResponsibilityDemo
```

## Örnek Çıktı

```
Yeni Destek Talebi - Önem Seviyesi: 2
1. Seviye Destek: Talep çözüldü - Yazılım güncellemesi gerekiyor

Yeni Destek Talebi - Önem Seviyesi: 5
1. Seviye Destek: Talep çözülemedi, bir üst seviyeye aktarılıyor.
2. Seviye Destek: Talep çözüldü - Sunucu performans problemi

Yeni Destek Talebi - Önem Seviyesi: 8
1. Seviye Destek: Talep çözülemedi, bir üst seviyeye aktarılıyor.
2. Seviye Destek: Talep çözülemedi, bir üst seviyeye aktarılıyor.
Yönetici Seviye Destek: Talep çözüldü - Kritik sistem arızası
```
