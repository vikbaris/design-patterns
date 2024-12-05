package behavioral.template2;

public class BankingDemo {
    public static void main(String[] args) {
        // Para çekme işlemi
        System.out.println("PARA ÇEKME İŞLEMİ");
        System.out.println("==================");
        BankingTransaction withdrawTransaction = new WithdrawTransaction("12345", 1000.0);
        withdrawTransaction.executeTransaction();
        
        System.out.println("\n--------------------\n");
        
        // Para yatırma işlemi
        System.out.println("PARA YATIRMA İŞLEMİ");
        System.out.println("===================");
        BankingTransaction depositTransaction = new DepositTransaction("12345", 2000.0);
        depositTransaction.executeTransaction();
        
        System.out.println("\n--------------------\n");
        
        // Para transfer işlemi
        System.out.println("PARA TRANSFER İŞLEMİ");
        System.out.println("====================");
        BankingTransaction transferTransaction = 
            new TransferTransaction("12345", "67890", 3000.0);
        transferTransaction.executeTransaction();
        
        System.out.println("\n--------------------\n");
        
        // Limit aşımı durumu
        try {
            System.out.println("LİMİT AŞIMI TEST");
            System.out.println("================");
            BankingTransaction largeWithdraw = new WithdrawTransaction("12345", 6000.0);
            largeWithdraw.executeTransaction();
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
