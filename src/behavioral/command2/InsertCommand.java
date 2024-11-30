package behavioral.command2;

public class InsertCommand implements EditorCommand {
    private TextEditor editor;
    private String text;
    private int position;
    
    public InsertCommand(TextEditor editor, String text, int position) {
        this.editor = editor;
        this.text = text;
        this.position = position;
    }
    
    @Override
    public void execute() {
        editor.insert(text, position);
    }
    
    @Override
    public void undo() {
        editor.delete(position, text.length());
    }
}
