package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

// Concrete Mediator
public class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // mesaj gönderen kullanıcı hariç diğer kullanıcılara mesajı ilet
            if (u != user) {
                u.receive(message);
            }
        }
    }
}
