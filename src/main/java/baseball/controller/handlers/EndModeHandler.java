package baseball.controller.handlers;

public class EndModeHandler implements ModeHandler {
    @Override
    public void process() {
        //do nothing
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
