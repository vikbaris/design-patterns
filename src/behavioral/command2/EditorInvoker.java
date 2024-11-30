package behavioral.command2;

import java.util.Stack;

public class EditorInvoker {
    private Stack<EditorCommand> undoStack;
    private Stack<EditorCommand> redoStack;
    
    public EditorInvoker() {
        undoStack = new Stack<>();
        // Stack kullanıyoruz çünkü:
        // 1. LIFO (Last-In-First-Out) yapısı, komut geçmişini yönetmek için idealdir
        // 2. push() ve pop() metodları, hızlı ekleme ve çıkarma işlemleri sağlar
        // 3. Java'nın yerleşik Stack sınıfı, thread-safe olduğu için çoklu iş parçacığı ortamlarında güvenlidir
        redoStack = new Stack<>();
    }
    
    public void executeCommand(EditorCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Yeni bir komut geldiğinde redo stack'i temizle
    }
    
    public void undo() {
        if (!undoStack.isEmpty()) {
            EditorCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }
    
    public void redo() {
        if (!redoStack.isEmpty()) {
            EditorCommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}
