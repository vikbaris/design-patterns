package structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
Ne Zaman Kullanılır?
Aşağıdaki senaryolarda Flyweight desenini kullanmak faydalı olur:

Uygulamanızda çok sayıda benzer nesne oluşturuluyorsa
Nesnelerin çoğu ortak verilere sahipse
Bellek tüketimi yüksekse
Nesne oluşturma maliyeti fazlaysa

Flyweight Deseninin Yapısı
Flyweight deseni genellikle şu bileşenlerden oluşur:

Flyweight (Hafif Nesne): Paylaşılabilir ortak durumu içeren sınıf
Flyweight Factory: Flyweight nesnelerini yöneten ve yöneten sınıf
Müşteri (Client): Flyweight nesnelerini kullanan sınıf
*/

// Ağaç türünün paylaşılan durumunu temsil eden Flyweight sınıfı
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    // Ağacın çizilmesi için metot
    public void render(int x, int y) {
        System.out.printf("Ağaç çizildi: %s renk: %s, konum: (%d, %d)%n", 
                          name, color, x, y);
    }
}

// Ağaç türlerini yöneten Flyweight Factory
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        // Eğer ağaç türü daha önce oluşturulmadıysa yeni oluştur
        return treeTypes.computeIfAbsent(
            name + color + texture, 
            k -> new TreeType(name, color, texture)
        );
    }

    public static int getTreeTypeCount() {
        return treeTypes.size();
    }
}

// Orman simülasyonu
class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void render() {
        for (Tree tree : trees) {
            tree.render();
        }
        System.out.println("Toplam ağaç türü sayısı: " + 
                           TreeFactory.getTreeTypeCount());
    }
}

// Bireysel ağaç sınıfı
class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void render() {
        type.render(x, y);
    }
}

// Örnek kullanım
public class FlyweightDemo {
    public static void main(String[] args) {
        Forest forest = new Forest();
        
        // Binlerce ağaç oluşturulabilir, ancak az sayıda ağaç türü paylaşılır
        for (int i = 0; i < 1000; i++) {
            forest.plantTree(
                new Random().nextInt(100), 
                new Random().nextInt(100), 
                "Meşe", 
                "Yeşil", 
                "Pürüzlü"
            );
            
            forest.plantTree(
                new Random().nextInt(100), 
                new Random().nextInt(100), 
                "Çam", 
                "Koyu Yeşil", 
                "Düz"
            );
        }
        
        forest.render();
    }
}