package behavioral.command2;

public class EditorDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorInvoker invoker = new EditorInvoker();
        
        System.out.println("--- Metin Ekleme ---");
        EditorCommand insertCommand = new InsertCommand(editor, "Merhaba ", 0);
        invoker.executeCommand(insertCommand);
        
        EditorCommand insertCommand2 = new InsertCommand(editor, "Dünya!", 7);
        invoker.executeCommand(insertCommand2);
        
        System.out.println("\n--- Geri Alma (Undo) ---");
        invoker.undo(); // "Dünya!" silinir
        
        System.out.println("\n--- İleri Alma (Redo) ---");
        invoker.redo(); // "Dünya!" geri gelir
        
        System.out.println("\n--- Metin Değiştirme ---");
        EditorCommand replaceCommand = new ReplaceCommand(editor, 7, 5, "Java!");
        invoker.executeCommand(replaceCommand);
        
        System.out.println("\n--- Metin Silme ---");
        EditorCommand deleteCommand = new DeleteCommand(editor, 0, 7);
        invoker.executeCommand(deleteCommand);
        
        System.out.println("\n--- Son İki İşlemi Geri Al ---");
        invoker.undo(); // Silme işlemi geri alınır
        invoker.undo(); // Değiştirme işlemi geri alınır
    }
}
