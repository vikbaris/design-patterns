package behavioral.template2;

public class TransferTransaction extends BankingTransaction {
    private String fromAccountId;
    private String toAccountId;
    private double amount;
    private static final double TRANSFER_LIMIT = 10000.0;

    public TransferTransaction(String fromAccountId, String toAccountId, double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    @Override
    protected void validateSecurity() {
        System.out.println("Para transfer işlemi için güvenlik kontrolü yapılıyor...");
        System.out.println("İşlem şifresi ve IP adresi kontrol ediliyor...");
        System.out.println("Alıcı hesap kara listede mi kontrol ediliyor...");
    }

    @Override
    protected void checkAccount() {
        System.out.println("Gönderen hesap kontrolü yapılıyor...");
        System.out.println("Gönderen hesap no: " + fromAccountId);
        System.out.println("Alıcı hesap kontrolü yapılıyor...");
        System.out.println("Alıcı hesap no: " + toAccountId);
        System.out.println("Bakiye kontrolü yapılıyor...");
    }

    @Override
    protected void checkTransactionLimit() {
        System.out.println("Transfer limit kontrolü yapılıyor...");
        if (amount > TRANSFER_LIMIT) {
            throw new IllegalArgumentException("Günlük transfer limiti aşıldı!");
        }
    }

    @Override
    protected void performTransaction() {
        System.out.println("Para transfer işlemi gerçekleştiriliyor...");
        System.out.println("Transfer edilen miktar: " + amount + " TL");
        System.out.println("Gönderen hesap: " + fromAccountId);
        System.out.println("Alıcı hesap: " + toAccountId);
        System.out.println("İşlem başarılı!");
    }

    @Override
    protected void notifyUser() {
        System.out.println("Gönderen kullanıcıya bildirim gönderildi: Transfer işlemi başarılı!");
        System.out.println("Alıcı kullanıcıya bildirim gönderildi: Hesabınıza para geldi!");
    }

    @Override
    protected String getTransactionType() {
        return "Para Transferi";
    }
}
