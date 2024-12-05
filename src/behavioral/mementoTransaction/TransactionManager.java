package behavioral.mementoTransaction;

import java.util.Stack;

// Caretaker sınıfı
public class TransactionManager {
    private final Stack<AccountMemento> undoStack = new Stack<>();
    private final Stack<AccountMemento> redoStack = new Stack<>();

    public void saveState(BankAccount account) {
        undoStack.push(account.save());
        // Yeni bir state kaydedildiğinde redo stack'i temizlenir
        redoStack.clear();
    }

    public boolean undo(BankAccount account) {
        if (undoStack.isEmpty()) {
            return false;
        }

        AccountMemento memento = undoStack.pop();
        redoStack.push(account.save()); // Mevcut durumu redo için kaydet
        account.restore(memento);
        return true;
    }

    public boolean redo(BankAccount account) {
        if (redoStack.isEmpty()) {
            return false;
        }

        AccountMemento memento = redoStack.pop();
        undoStack.push(account.save()); // Mevcut durumu undo için kaydet
        account.restore(memento);
        return true;
    }
}
