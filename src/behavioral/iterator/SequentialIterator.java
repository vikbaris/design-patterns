package behavioral.iterator;

import java.util.List;

public class SequentialIterator implements MusicIterator {
    private List<Song> songs;
    private int currentPosition;

    public SequentialIterator(List<Song> songs) {
        this.songs = songs;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < songs.size();
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            return null;
        }
        return songs.get(currentPosition++);
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }

    @Override
    public boolean hasPrevious() {
        return currentPosition > 0;
    }

    @Override
    public Song previous() {
        if (!hasPrevious()) {
            return null;
        }
        return songs.get(--currentPosition);
    }
}
