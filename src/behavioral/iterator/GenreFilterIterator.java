package behavioral.iterator;

import java.util.List;

public class GenreFilterIterator implements MusicIterator {
    private List<Song> songs;
    private String genre;
    private int currentPosition;

    public GenreFilterIterator(List<Song> songs, String genre) {
        this.songs = songs;
        this.genre = genre;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentPosition < songs.size()) {
            if (songs.get(currentPosition).getGenre().equals(genre)) {
                return true;
            }
            currentPosition++;
        }
        return false;
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
}
