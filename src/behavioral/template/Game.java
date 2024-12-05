package behavioral.template;

/**
 * Abstract sınıf - Oyun şablonunu tanımlar
 */
public abstract class Game {
    
    // Template method - final olarak işaretlenmiştir ve override edilemez
    public final void play() {
        // Oyun başlatma
        initialize();
        
        // Oyuncuları hazırlama
        prepareGame();
        
        // Oyun döngüsü
        startGame();
        
        // Oyun bitişi
        endGame();
    }
    
    // Hook methods - Alt sınıflar tarafından uygulanacak
    protected abstract void initialize();
    protected abstract void prepareGame();
    protected abstract void startGame();
    protected abstract void endGame();
}
