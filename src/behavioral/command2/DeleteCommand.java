package behavioral.command2;

public class DeleteCommand implements EditorCommand {
    private TextEditor editor;
    private int position;
    private int length;
    private String deletedText;
    
    public DeleteCommand(TextEditor editor, int position, int length) {
        this.editor = editor;
        this.position = position;
        this.length = length;
        this.deletedText = editor.getContent().substring(position, position + length);
    }
    
    @Override
    public void execute() {
        editor.delete(position, length);
    }
    
    @Override
    public void undo() {
        editor.insert(deletedText, position);
    }
}
