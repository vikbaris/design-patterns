package behavioral.command;

// Birden fazla komutu birlikte çalıştıran komut
public class MacroCommand implements Command {
    private Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        // Komutları tersten geri al
        for (int i = commands.length - 1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}
