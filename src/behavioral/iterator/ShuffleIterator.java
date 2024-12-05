package behavioral.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleIterator implements MusicIterator {
    private List<Song> shuffledSongs;
    private int currentPosition;

    public ShuffleIterator(List<Song> songs) {
        // Orijinal listeyi korumak için kopyasını oluştur
        this.shuffledSongs = new ArrayList<>(songs);
        shuffle();
        this.currentPosition = 0;
    }

    private void shuffle() {
        Collections.shuffle(shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return currentPosition < shuffledSongs.size();
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            return null;
        }
        return shuffledSongs.get(currentPosition++);
    }

    @Override
    public void reset() {
        shuffle();
        currentPosition = 0;
    }
}
