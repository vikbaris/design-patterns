package behavioral.mementoTransaction;

public class TransactionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // 1000 TL başlangıç bakiyesi
        TransactionManager transactionManager = new TransactionManager();

        // İlk durumu kaydet
        transactionManager.saveState(account);
        System.out.println("Başlangıç bakiyesi: " + account.getBalance() + " TL");

        // Para yatırma işlemi
        account.deposit(500);
        transactionManager.saveState(account);
        System.out.println("Para yatırma sonrası: " + account.getBalance() + " TL");
        System.out.println("Son işlem: " + account.getLastTransaction());

        // Para çekme işlemi
        account.withdraw(300);
        transactionManager.saveState(account);
        System.out.println("Para çekme sonrası: " + account.getBalance() + " TL");
        System.out.println("Son işlem: " + account.getLastTransaction());

        // Son işlemi geri al (undo)
        transactionManager.undo(account);
        System.out.println("\nSon işlem geri alındı");
        System.out.println("Güncel bakiye: " + account.getBalance() + " TL");
        System.out.println("Son işlem: " + account.getLastTransaction());

        // Geri alınan işlemi tekrar yap (redo)
        transactionManager.redo(account);
        System.out.println("\nİşlem tekrar yapıldı");
        System.out.println("Güncel bakiye: " + account.getBalance() + " TL");
        System.out.println("Son işlem: " + account.getLastTransaction());
    }
}
