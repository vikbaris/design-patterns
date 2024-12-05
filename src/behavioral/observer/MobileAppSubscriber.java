package behavioral.observer;

public class MobileAppSubscriber implements Channel {
    private String userName;
    private String deviceToken;

    public MobileAppSubscriber(String userName, String deviceToken) {
        this.userName = userName;
        this.deviceToken = deviceToken;
    }

    @Override
    public void update(String news) {
        System.out.println("Push notification gönderiliyor -> " + userName);
        System.out.println("Device Token: " + deviceToken);
        System.out.println("Bildirim içeriği: " + news);
        System.out.println("Push notification başarıyla gönderildi!\n");
    }
}
