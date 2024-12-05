package behavioral.memento;

// Memento: Originator'ın durumunu saklayan sınıf
public class TextEditorMemento {
    private final String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getSavedContent() {
        return content;
    }
}
