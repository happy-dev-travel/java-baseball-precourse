package baseball.controller.handlers;

import baseball.view.BaseBallView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SelectionModeHandler implements ModeHandler {
    private final BaseBallView view;
    private final String StartNewGame = "1";
    private final String ExitGame = "2";

    public SelectionModeHandler(BaseBallView view) {
        this.view = view;
    }

    @Override
    public GameStatus process() {
        this.view.showSuccess();
        String userSelection = "";
        while(inValidSelection(userSelection)){
            userSelection = readLine();
        }
        return handleUserSelection(userSelection);
    }

    private boolean inValidSelection(String userSelection) {
        return !(userSelection.equals(StartNewGame) || userSelection.equals(ExitGame));
    }

    private GameStatus handleUserSelection(String userSelection){
        if (userSelection.equals(StartNewGame)) {
            return new GameStatus(true,false);
        }

        this.view.showEnd();
        return new GameStatus(false,false);
    }
}
