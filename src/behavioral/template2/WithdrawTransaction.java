package behavioral.template2;

public class WithdrawTransaction extends BankingTransaction {
    private String accountId;
    private double amount;
    private static final double DAILY_LIMIT = 5000.0;

    public WithdrawTransaction(String accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    protected void validateSecurity() {
        System.out.println("Para çekme işlemi için güvenlik doğrulaması yapılıyor...");
        System.out.println("İşlem şubeden yapılıyorsa kimlik kontrolü, ATM'den yapılıyorsa kart ve PIN kontrolü");
    }

    @Override
    protected void checkAccount() {
        System.out.println("Hesap kontrolü yapılıyor...");
        System.out.println("Hesap no: " + accountId);
        System.out.println("Bakiye kontrolü yapılıyor...");
    }

    @Override
    protected void checkTransactionLimit() {
        System.out.println("Günlük para çekme limiti kontrolü yapılıyor...");
        if (amount > DAILY_LIMIT) {
            throw new IllegalArgumentException("Günlük para çekme limiti aşıldı!");
        }
    }

    @Override
    protected void performTransaction() {
        System.out.println("Para çekme işlemi gerçekleştiriliyor...");
        System.out.println("Çekilen miktar: " + amount + " TL");
        System.out.println("İşlem başarılı!");
    }

    @Override
    protected String getTransactionType() {
        return "Para Çekme";
    }
}
