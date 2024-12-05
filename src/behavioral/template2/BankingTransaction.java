package behavioral.template2;

/**
 * Banka işlemleri için temel şablon sınıfı
 */
public abstract class BankingTransaction {
    
    // Template method
    public final void executeTransaction() {
        // 1. Güvenlik kontrolü
        validateSecurity();
        
        // 2. Hesap kontrolü
        checkAccount();
        
        // 3. İşlem limiti kontrolü
        checkTransactionLimit();
        
        // 4. Ana işlem
        performTransaction();
        
        // 5. Kayıt tutma
        logTransaction();
        
        // 6. Bildirim gönderme
        notifyUser();
    }
    
    // Hook methods
    protected abstract void validateSecurity();
    protected abstract void checkAccount();
    protected abstract void checkTransactionLimit();
    protected abstract void performTransaction();
    
    // Ortak metodlar (alt sınıflar override edebilir)
    protected void logTransaction() {
        System.out.println("İşlem kaydı oluşturuldu: " + getTransactionType());
    }
    
    protected void notifyUser() {
        System.out.println("Kullanıcıya bildirim gönderildi: " + getTransactionType() + " işlemi başarılı!");
    }
    
    // İşlem tipini döndüren yardımcı metod
    protected abstract String getTransactionType();
}
