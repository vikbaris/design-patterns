package behavioral.mediator2;

public class BankingDemo {
    public static void main(String[] args) {
        // Mediator oluştur
        TransferMediator mediator = new BankingMediator();

        // Servisleri oluştur
        TransferService transferService = new TransferService(mediator);
        NotificationService notificationService = new NotificationService(mediator);
        ValidationService validationService = new ValidationService(mediator, transferService);

        // Hesapları oluştur
        Account account1 = new Account("1", 1000.0, mediator);
        Account account2 = new Account("2", 500.0, mediator);

        // Para transferi yap
        System.out.println("Transfer öncesi bakiyeler:");
        System.out.println("Hesap 1: " + account1.getBalance() + " TL");
        System.out.println("Hesap 2: " + account2.getBalance() + " TL");
        System.out.println("\nPara transferi yapılıyor...\n");

        account1.sendMoney("2", 300.0);

        System.out.println("\nTransfer sonrası bakiyeler:");
        System.out.println("Hesap 1: " + account1.getBalance() + " TL");
        System.out.println("Hesap 2: " + account2.getBalance() + " TL");

        // Yetersiz bakiye durumunu test et
        System.out.println("\nYetersiz bakiye testi:");
        account2.sendMoney("1", 1000.0);
    }
}
