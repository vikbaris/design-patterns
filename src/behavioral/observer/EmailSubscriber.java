package behavioral.observer;

public class EmailSubscriber implements Channel {
    private String email;
    
    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("Email gönderiliyor -> " + email);
        System.out.println("Haber içeriği: " + news);
        System.out.println("Email başarıyla gönderildi!\n");
    }
}
