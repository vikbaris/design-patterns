package behavioral.mediator;

public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        
        User user1 = new ChatUser(mediator, "Baris");
        User user2 = new ChatUser(mediator, "Ahmet");
        User user3 = new ChatUser(mediator, "Mehmet");
        
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        
        user1.send("Merhaba!");
        System.out.println("------------------------");
        user2.send("Selam!");
    }
}
