package behavioral.mementoTransaction;

// Originator sınıfı
public class BankAccount {
    private double balance;
    private String lastTransaction;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.lastTransaction = "Hesap açıldı";
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.lastTransaction = amount + " TL yatırıldı";
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            this.lastTransaction = amount + " TL çekildi";
        } else {
            throw new IllegalStateException("Yetersiz bakiye");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    // Mevcut durumu kaydet
    public AccountMemento save() {
        return new AccountMemento(balance, lastTransaction);
    }

    // Önceki duruma geri dön
    public void restore(AccountMemento memento) {
        this.balance = memento.getBalance();
        this.lastTransaction = memento.getLastTransaction();
    }
}
