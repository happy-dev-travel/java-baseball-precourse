package baseball.controller;

import baseball.controller.handlers.GameModeHandler;
import baseball.controller.handlers.GameStatus;
import baseball.controller.handlers.ModeHandler;
import baseball.controller.handlers.SelectionModeHandler;
import baseball.model.BaseBallModel;
import baseball.view.BaseBallView;

public class SimpleBaseBallController implements BaseBallController {
    private final ModeHandler gameModeHandler;
    private final ModeHandler selectionModelHandler;
    private boolean isRunning;
    private boolean inSelection;

    public SimpleBaseBallController(BaseBallModel model, BaseBallView view) {
        this.gameModeHandler = new GameModeHandler(model, view);
        this.selectionModelHandler = new SelectionModeHandler(view);
        this.isRunning = true;
    }

    @Override
    public void start() {
        while(isRunning){
            GameStatus status = getGameHandler().process();
            updateGameStatus(status);
        }
    }

    private ModeHandler getGameHandler() {
        if(inSelection)
            return selectionModelHandler;

        return gameModeHandler;
    }

    private void updateGameStatus(GameStatus status) {
        this.isRunning = status.getIsRunning();
        this.inSelection = status.getIsInSelection();
    }
}
