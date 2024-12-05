package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;
    private boolean shuffle;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.shuffle = false;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public String getName() {
        return name;
    }

    public MusicIterator getIterator() {
        return shuffle ? new ShuffleIterator(songs) : new SequentialIterator(songs);
    }

    public int getTotalDuration() {
        return songs.stream().mapToInt(Song::getDuration).sum();
    }

    public int getSongCount() {
        return songs.size();
    }
}
