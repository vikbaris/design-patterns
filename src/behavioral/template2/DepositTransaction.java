package behavioral.template2;

public class DepositTransaction extends BankingTransaction {
    private String accountId;
    private double amount;
    private static final double SUSPICIOUS_AMOUNT = 50000.0;

    public DepositTransaction(String accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    protected void validateSecurity() {
        System.out.println("Para yatırma işlemi için güvenlik kontrolü yapılıyor...");
        if (amount >= SUSPICIOUS_AMOUNT) {
            System.out.println("Yüksek miktarlı işlem tespit edildi. Ek güvenlik kontrolleri uygulanıyor...");
        }
    }

    @Override
    protected void checkAccount() {
        System.out.println("Hesap kontrolü yapılıyor...");
        System.out.println("Hesap no: " + accountId);
        System.out.println("Hesap aktiflik durumu kontrol ediliyor...");
    }

    @Override
    protected void checkTransactionLimit() {
        System.out.println("Para yatırma limit kontrolü yapılıyor...");
        // Para yatırma için genelde limit olmaz, sadece şüpheli işlem kontrolü yapılır
        if (amount >= SUSPICIOUS_AMOUNT) {
            System.out.println("Şüpheli işlem bildirimi oluşturuluyor...");
        }
    }

    @Override
    protected void performTransaction() {
        System.out.println("Para yatırma işlemi gerçekleştiriliyor...");
        System.out.println("Yatırılan miktar: " + amount + " TL");
        System.out.println("İşlem başarılı!");
    }

    @Override
    protected String getTransactionType() {
        return "Para Yatırma";
    }
}
