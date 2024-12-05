package behavioral.iterator;

public interface MusicIterator {
    boolean hasNext();
    Song next();
    void reset();
    
    // Opsiyonel: Geri gitme özelliği
    default boolean hasPrevious() {
        return false;
    }
    
    default Song previous() {
        throw new UnsupportedOperationException("Previous operation not supported");
    }
}
