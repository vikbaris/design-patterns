package structural;

import java.util.ArrayList;
import java.util.List;

// Component Interface (Ortak Arayüz)
interface FileSystemComponent {
    String getName();
    long getSize();
    void display();
}

// Leaf (Yaprak) Sınıfı - Dosya
class File implements FileSystemComponent {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void display() {
        System.out.println("Dosya: " + name + " (Boyut: " + size + " KB)");
    }
}

// Composite (Bileşik) Sınıfı - Klasör
class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Folder(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        // Tüm alt bileşenlerin boyutunu hesapla
        return components.stream()
                .mapToLong(FileSystemComponent::getSize)
                .sum();
    }

    @Override
    public void display() {
        System.out.println("Klasör: " + name);
        // Tüm alt bileşenleri göster
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}

// Kullanım Örneği
public class CompositePattern2 {
    public static void main(String[] args) {
        // Dosya sistemi oluşturma
        Folder rootFolder = new Folder("Belgeler");
        
        // Alt klasörler
        Folder workFolder = new Folder("İş Dosyaları");
        Folder personalFolder = new Folder("Kişisel Dosyalar");
        
        // Dosyalar
        File rapor1 = new File("Proje Raporu.pdf", 250);
        File rapor2 = new File("Analiz Raporu.docx", 150);
        File ozgecmis = new File("Özgeçmiş.pdf", 50);
        
        // Klasörlere dosyaları ekleme
        workFolder.addComponent(rapor1);
        workFolder.addComponent(rapor2);
        
        personalFolder.addComponent(ozgecmis);
        
        // Root klasöre alt klasörleri ekleme
        rootFolder.addComponent(workFolder);
        rootFolder.addComponent(personalFolder);
        
        // Dosya sistemini görüntüleme
        System.out.println("Dosya Sistemi Yapısı:");
        rootFolder.display();
        
        // Toplam boyutu hesaplama
        System.out.println("\nToplam Boyut: " + rootFolder.getSize() + " KB");
    }
}