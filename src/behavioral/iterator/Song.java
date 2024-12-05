package behavioral.iterator;

public class Song {
    private String name;
    private String artist;
    private String genre;
    private int duration; // seconds

    public Song(String name, String artist, String genre, int duration) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d:%02d)", artist, name, duration / 60, duration % 60);
    }
}
