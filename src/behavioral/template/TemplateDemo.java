package behavioral.template;

public class TemplateDemo {
    public static void main(String[] args) {
        System.out.println("Satranç Oyunu Başlıyor...\n");
        Game chess = new ChessGame();
        chess.play();
        
        System.out.println("\n--------------------------------\n");
        
        System.out.println("Futbol Maçı Başlıyor...\n");
        Game football = new FootballGame();
        football.play();
    }
}
