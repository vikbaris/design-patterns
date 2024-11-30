package behavioral.command;

import java.util.Stack;

// Invoker sınıfı
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack;
    private static final int SLOT_COUNT = 7;

    public RemoteControl() {
        onCommands = new Command[SLOT_COUNT];
        offCommands = new Command[SLOT_COUNT];
        undoStack = new Stack<>();

        // Boş komut nesnesi ile başlat
        Command noCommand = new NoCommand();
        for (int i = 0; i < SLOT_COUNT; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    /**
     * Belirtilen yuvaya açma ve kapama komutlarını atar.
     * @param slot Komutların atanacağı yuva numarası
     * @param onCommand Açma komutu
     * @param offCommand Kapama komutu
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        onCommands[slot].execute();
        undoStack.push(onCommands[slot]);
    }

    public void offButtonPressed(int slot) {
        offCommands[slot].execute();
        undoStack.push(offCommands[slot]);
    }

    public void undoButtonPressed() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
        }
    }
}

// Boş komut sınıfı - Null Object Pattern
class NoCommand implements Command {
    @Override
    public void execute() {}

    @Override
    public void undo() {}
}
