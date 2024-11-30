package behavioral.mediator2;

public class BankingMediator implements TransferMediator {
    // Mediator, diğer servisleri yöneten ve aralarındaki iletişimi koordine eden merkezi bir birimdir.
    // Bu sınıf, TransferMediator arayüzünü uygulayarak para transferi işlemlerini yönetir.
    // Diğer servisler (TransferService, NotificationService, ValidationService) bu mediator üzerinden iletişim kurar.
    // Böylece servisler arasındaki bağımlılıklar azaltılır ve sistem daha modüler hale gelir.
    private TransferService transferService;
    private NotificationService notificationService;
    private ValidationService validationService;

    @Override
    public void transfer(String fromAccount, String toAccount, double amount) {
        transferService.executeTransfer(fromAccount, toAccount, amount);
    }

    @Override
    public void notifyUser(String accountId, String message) {
        notificationService.sendNotification(accountId, message);
    }

    @Override
    public boolean validateAccount(String accountId, double amount) {
        return validationService.validateTransfer(accountId, amount);
    }

    @Override
    public void registerAccount(Account account) {
        transferService.addAccount(account);
    }

    @Override
    public void registerTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public void registerNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void registerValidationService(ValidationService validationService) {
        this.validationService = validationService;
    }
}
