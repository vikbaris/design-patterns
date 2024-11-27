package creational;

// Product Interface
public interface Notification {
    void notifyUser();
}

// Concrete Products
public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email notification");
    }
}

public class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push notification");
    }
}

// Creator
public abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void notifyUser() {
        Notification notification = createNotification();
        notification.notifyUser();
    }
}

// Concrete Creators
public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

// Client Code
public class FactoryPattern {
    public static void main(String[] args) {
        NotificationFactory factory;

        // Send an SMS notification
        factory = new SMSNotificationFactory();
        factory.notifyUser(); // Outputs: Sending an SMS notification

        // Send an Email notification
        factory = new EmailNotificationFactory();
        factory.notifyUser(); // Outputs: Sending an Email notification

        // Send a Push notification
        factory = new PushNotificationFactory();
        factory.notifyUser(); // Outputs: Sending a Push notification
    }
}