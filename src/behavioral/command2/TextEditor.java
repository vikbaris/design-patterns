package behavioral.command2;

// Receiver sınıfı
public class TextEditor {
    private StringBuilder content;
    
    public TextEditor() {
        this.content = new StringBuilder();
    }
    
    public void insert(String text, int position) {
        content.insert(position, text);
        System.out.println("Metin eklendi: " + content.toString());
    }
    
    public void delete(int position, int length) {
        content.delete(position, position + length);
        System.out.println("Metin silindi: " + content.toString());
    }
    
    public void replace(int position, int length, String newText) {
        content.replace(position, position + length, newText);
        System.out.println("Metin değiştirildi: " + content.toString());
    }
    
    public String getContent() {
        return content.toString();
    }
}
