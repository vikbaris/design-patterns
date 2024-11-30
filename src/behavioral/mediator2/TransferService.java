package behavioral.mediator2;

import java.util.HashMap;
import java.util.Map;

public class TransferService {
    private Map<String, Account> accounts;
    private TransferMediator mediator;

    public TransferService(TransferMediator mediator) {
        this.accounts = new HashMap<>();
        this.mediator = mediator;
        this.mediator.registerTransferService(this);
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    public void executeTransfer(String fromAccountId, String toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount != null && toAccount != null) {
            fromAccount.debit(amount);
            toAccount.credit(amount);
        }
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
