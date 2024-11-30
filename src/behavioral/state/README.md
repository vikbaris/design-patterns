# State Design Pattern

State (Durum) tasarım deseni, bir nesnenin iç durumu değiştiğinde davranışının da değişmesini sağlayan davranışsal bir tasarım desenidir.

## Kullanım Amacı
- Nesnenin davranışını durumuna göre değiştirmek
- Karmaşık if-else yapılarından kurtulmak
- Durum geçişlerini merkezi bir yerden yönetmek
- Kodun bakımını ve genişletilebilirliğini artırmak

## Örnek Senaryo
Bu örnekte, bir e-ticaret sistemindeki sipariş durumlarını yönetiyoruz:

1. NEW: Yeni oluşturulmuş sipariş
2. CONFIRMED: Onaylanmış sipariş
3. SHIPPED: Kargoya verilmiş sipariş
4. DELIVERED: Teslim edilmiş sipariş
5. CANCELLED: İptal edilmiş sipariş

Her durum için farklı işlemler ve geçiş kuralları bulunmaktadır.
