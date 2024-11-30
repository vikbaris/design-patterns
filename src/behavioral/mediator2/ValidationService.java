package behavioral.mediator2;

public class ValidationService {
    private TransferMediator mediator;
    private TransferService transferService;

    public ValidationService(TransferMediator mediator, TransferService transferService) {
        this.mediator = mediator;
        this.transferService = transferService;
        this.mediator.registerValidationService(this);
    }

    public boolean validateTransfer(String accountId, double amount) {
        Account account = transferService.getAccounts().get(accountId);
        if (account == null) {
            mediator.notifyUser(accountId, "Hesap bulunamadı!");
            return false;
        }
        if (account.getBalance() < amount) {
            mediator.notifyUser(accountId, "Yetersiz bakiye!");
            return false;
        }
        return true;
    }
}
