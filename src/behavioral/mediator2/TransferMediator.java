package behavioral.mediator2;

public interface TransferMediator {
    void transfer(String fromAccount, String toAccount, double amount);
    void notifyUser(String accountId, String message);
    boolean validateAccount(String accountId, double amount);
    void registerAccount(Account account);
    void registerTransferService(TransferService transferService);
    void registerNotificationService(NotificationService notificationService);
    void registerValidationService(ValidationService validationService);
}
