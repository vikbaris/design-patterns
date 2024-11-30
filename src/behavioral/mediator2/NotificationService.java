package behavioral.mediator2;

public class NotificationService {
    private TransferMediator mediator;

    public NotificationService(TransferMediator mediator) {
        this.mediator = mediator;
        this.mediator.registerNotificationService(this);
    }

    public void sendNotification(String accountId, String message) {
        System.out.println("Bildirim - Hesap: " + accountId + " - Mesaj: " + message);
    }
}
