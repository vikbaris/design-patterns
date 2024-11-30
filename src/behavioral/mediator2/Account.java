package behavioral.mediator2;

public class Account {
    private String accountId;
    private double balance;
    private TransferMediator mediator;

    public Account(String accountId, double balance, TransferMediator mediator) {
        this.accountId = accountId;
        this.balance = balance;
        this.mediator = mediator;
        this.mediator.registerAccount(this);
    }

    public void sendMoney(String toAccount, double amount) {
        if (mediator.validateAccount(this.accountId, amount)) {
            mediator.transfer(this.accountId, toAccount, amount);
        }
    }

    public void credit(double amount) {
        this.balance += amount;
        mediator.notifyUser(accountId, "Hesabınıza " + amount + " TL yatırıldı. Yeni bakiye: " + balance + " TL");
    }

    public void debit(double amount) {
        this.balance -= amount;
        mediator.notifyUser(accountId, "Hesabınızdan " + amount + " TL çekildi. Yeni bakiye: " + balance + " TL");
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }
}
