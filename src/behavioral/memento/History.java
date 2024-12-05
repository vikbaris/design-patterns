package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

// Caretaker: Memento'ları yöneten sınıf
public class History {
    private final List<TextEditorMemento> mementos = new ArrayList<>();
    private int currentState = -1;

    public void push(TextEditorMemento memento) {
        mementos.add(memento);
        currentState++;
    }

    public TextEditorMemento undo() {
        if (currentState <= 0) {
            return null;
        }
        currentState--;
        return mementos.get(currentState);
    }

    public TextEditorMemento redo() {
        if (currentState >= mementos.size() - 1) {
            return null;
        }
        currentState++;
        return mementos.get(currentState);
    }
}
