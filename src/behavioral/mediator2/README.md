# Banking System with Mediator Pattern

Bu örnekte, bir bankacılık sisteminde para transferi işlemlerinin nasıl mediator pattern ile yönetilebileceğini gösteriyoruz.

## Sistem Bileşenleri
- TransferMediator: Para transferi işlemlerini koordine eden mediator
- Account: Banka hesabı işlemleri
- TransferService: Para transferi işlemleri
- NotificationService: Bildirim işlemleri
- ValidationService: Hesap doğrulama işlemleri

## İş Akışı
1. Kullanıcı para transferi talebi oluşturur
2. Mediator hesap validasyonlarını kontrol eder
3. Transfer işlemi gerçekleştirilir
4. İlgili kullanıcılara bildirim gönderilir
