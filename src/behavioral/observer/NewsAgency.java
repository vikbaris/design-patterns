package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        // Yeni haber geldiğinde tüm kanalları bilgilendir
        for (Channel channel : channels) {
            channel.update(this.news);
        }
    }

    public String getNews() {
        return news;
    }
}
