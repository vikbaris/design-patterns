package behavioral.mementoTransaction;

// Memento sınıfı
public class AccountMemento {
    private final double balance;
    private final String lastTransaction;

    public AccountMemento(double balance, String lastTransaction) {
        this.balance = balance;
        this.lastTransaction = lastTransaction;
    }

    public double getBalance() {
        return balance;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }
}
