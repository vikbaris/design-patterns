package behavioral.observer;

public class NewsChannel implements Channel {
    private String name;
    private String lastNews;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        this.lastNews = news;
        display();
    }

    private void display() {
        System.out.println(name + " kanalı son dakika haberi yayınlıyor: " + lastNews);
    }

    public String getLastNews() {
        return lastNews;
    }
}
