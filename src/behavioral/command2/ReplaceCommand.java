package behavioral.command2;

public class ReplaceCommand implements EditorCommand {
    private TextEditor editor;
    private int position;
    private int length;
    private String newText;
    private String oldText;
    
    public ReplaceCommand(TextEditor editor, int position, int length, String newText) {
        this.editor = editor;
        this.position = position;
        this.length = length;
        this.newText = newText;
        this.oldText = editor.getContent().substring(position, position + length);
    }
    
    @Override
    public void execute() {
        editor.replace(position, length, newText);
    }
    
    @Override
    public void undo() {
        editor.replace(position, newText.length(), oldText);
    }
}
