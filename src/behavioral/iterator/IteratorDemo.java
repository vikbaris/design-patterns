package behavioral.iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        // Playlist oluştur
        Playlist myPlaylist = new Playlist("Favori Şarkılarım");

        // Şarkıları ekle
        myPlaylist.addSong(new Song("Bohemian Rhapsody", "Queen", "Rock", 354));
        myPlaylist.addSong(new Song("Stairway to Heaven", "Led Zeppelin", "Rock", 482));
        myPlaylist.addSong(new Song("Shape of You", "Ed Sheeran", "Pop", 234));
        myPlaylist.addSong(new Song("Billie Jean", "Michael Jackson", "Pop", 294));
        myPlaylist.addSong(new Song("Sweet Child O' Mine", "Guns N' Roses", "Rock", 356));
        myPlaylist.addSong(new Song("Bad Guy", "Billie Eilish", "Pop", 194));

        // 1. Sıralı çalma listesi
        System.out.println("=== Sıralı Çalma ===");
        MusicIterator sequentialIterator = myPlaylist.getIterator();
        while (sequentialIterator.hasNext()) {
            System.out.println(sequentialIterator.next());
        }

        // 2. Karışık çalma listesi
        System.out.println("\n=== Karışık Çalma ===");
        myPlaylist.setShuffle(true);
        MusicIterator shuffleIterator = myPlaylist.getIterator();
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next());
        }

        // 3. Sadece Rock şarkıları
        System.out.println("\n=== Rock Şarkıları ===");
        GenreFilterIterator rockIterator = new GenreFilterIterator(java.util.Arrays.asList(
            new Song("Bohemian Rhapsody", "Queen", "Rock", 354),
            new Song("Shape of You", "Ed Sheeran", "Pop", 234),
            new Song("Sweet Child O' Mine", "Guns N' Roses", "Rock", 356)
        ), "Rock");

        while (rockIterator.hasNext()) {
            System.out.println(rockIterator.next());
        }

        // 4. İleri-geri gezinme örneği
        System.out.println("\n=== İleri-Geri Gezinme ===");
        myPlaylist.setShuffle(false);
        SequentialIterator navIterator = (SequentialIterator) myPlaylist.getIterator();
        
        // İlk 3 şarkıyı çal
        for (int i = 0; i < 3; i++) {
            if (navIterator.hasNext()) {
                System.out.println("İleri: " + navIterator.next());
            }
        }
        
        // 2 şarkı geri git
        for (int i = 0; i < 2; i++) {
            if (navIterator.hasPrevious()) {
                System.out.println("Geri: " + navIterator.previous());
            }
        }
    }
}
