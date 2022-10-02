package baseball.controller.handlers;

public class GameStatus {
    private final boolean isRunning;
    private final boolean inSelection;

    public GameStatus(boolean isRunning, boolean inSelection) {
        this.isRunning = isRunning;
        this.inSelection = inSelection;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public boolean getIsInSelection() {
        return inSelection;
    }
}
