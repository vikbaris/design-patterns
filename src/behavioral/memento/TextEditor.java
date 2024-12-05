package behavioral.memento;

// Originator: Durumu saklanacak olan sınıf
public class TextEditor {
    private String content;

    public TextEditor() {
        this.content = "";
    }

    public void write(String text) {
        content += text;
    }

    public String getContent() {
        return content;
    }

    // Mevcut durumu kaydetmek için Memento oluşturur
    public TextEditorMemento save() {
        return new TextEditorMemento(content);
    }

    // Memento'dan durumu geri yükler
    public void restore(TextEditorMemento memento) {
        this.content = memento.getSavedContent();
    }
}
