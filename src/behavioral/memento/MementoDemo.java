package behavioral.memento;

public class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // İlk metin yazılıyor
        editor.write("Merhaba ");
        history.push(editor.save());

        // İkinci metin ekleniyor
        editor.write("Dünya!");
        history.push(editor.save());

        editor.write("Java!");
        history.push(editor.save());


        System.out.println("Güncel metin: " + editor.getContent());

        // Geri alma işlemi
        TextEditorMemento undoMemento = history.undo();
        if (undoMemento != null) {
            editor.restore(undoMemento);
            System.out.println("Geri alındıktan sonra: " + editor.getContent());
        }

        // İleri alma işlemi
        TextEditorMemento redoMemento = history.redo();
        if (redoMemento != null) {
            editor.restore(redoMemento);
            System.out.println("İleri alındıktan sonra: " + editor.getContent());
        }
    }
}
