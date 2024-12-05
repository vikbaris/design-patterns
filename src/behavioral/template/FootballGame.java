package behavioral.template;

public class FootballGame extends Game {
    
    @Override
    protected void initialize() {
        System.out.println("Futbol maçı başlatılıyor...");
        System.out.println("Saha kontrol ediliyor...");
    }
    
    @Override
    protected void prepareGame() {
        System.out.println("Takımlar sahaya çıkıyor...");
        System.out.println("Isınma hareketleri yapılıyor...");
        System.out.println("Hakemler hazır...");
    }
    
    @Override
    protected void startGame() {
        System.out.println("Maç başladı!");
        System.out.println("İlk yarı oynanıyor...");
        System.out.println("Devre arası...");
        System.out.println("İkinci yarı oynanıyor...");
    }
    
    @Override
    protected void endGame() {
        System.out.println("Maç sona erdi!");
        System.out.println("Skor açıklanıyor...");
        System.out.println("İstatistikler kaydediliyor...");
    }
}
