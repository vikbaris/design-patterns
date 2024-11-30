package behavioral.command;

public class TVVolumeCommand implements Command {
    private TV tv;
    private int previousVolume;
    private int newVolume;

    public TVVolumeCommand(TV tv, int volume) {
        this.tv = tv;
        this.newVolume = volume;
    }

    @Override
    public void execute() {
        tv.setVolume(newVolume);
    }

    @Override
    public void undo() {
        tv.setVolume(previousVolume);
    }
}
