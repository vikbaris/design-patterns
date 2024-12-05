package behavioral.template;

public class ChessGame extends Game {
    
    @Override
    protected void initialize() {
        System.out.println("Satranç oyunu başlatılıyor...");
        System.out.println("Satranç tahtası hazırlanıyor...");
    }
    
    @Override
    protected void prepareGame() {
        System.out.println("Taşlar diziliyor...");
        System.out.println("Oyuncular hazır...");
    }
    
    @Override
    protected void startGame() {
        System.out.println("Beyaz taş ile oyun başladı!");
        System.out.println("Oyuncular sırayla hamle yapıyor...");
        System.out.println("Şah mat!");
    }
    
    @Override
    protected void endGame() {
        System.out.println("Oyun bitti!");
        System.out.println("Kazanan açıklanıyor...");
        System.out.println("Puanlar kaydediliyor...");
    }
}
