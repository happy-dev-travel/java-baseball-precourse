package baseball.controller.handlers;

import baseball.view.BaseBallView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SelectionModeHandler implements ModeHandler {
    private final BaseBallView view;

    public SelectionModeHandler(BaseBallView view) {
        this.view = view;
    }

    @Override
    public GameStatus process() {
        this.view.showSuccess();
        return handleUserInputForNextGame();
    }

    private GameStatus handleUserInputForNextGame() {
        String input = readLine();
        if (input.equals("1")) {
            return new GameStatus(true,false);
        }
        if(input.equals("2")){
            this.view.showEnd();
            return new GameStatus(false,false);
        }
        return handleUserInputForNextGame();
    }
}
