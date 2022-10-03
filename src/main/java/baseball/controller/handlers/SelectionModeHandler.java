package baseball.controller.handlers;

import baseball.controller.BaseBallController;
import baseball.model.BaseBallModel;
import baseball.view.BaseBallView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SelectionModeHandler implements ModeHandler {
    private final BaseBallController controller;
    private final BaseBallView view;
    private final BaseBallModel model;
    private final String StartNewGame = "1";
    private final String ExitGame = "2";

    public SelectionModeHandler(BaseBallModel model,BaseBallView view,BaseBallController controller) {
        this.controller = controller;
        this.view = view;
        this.model = model;
    }

    @Override
    public void process() {
        this.view.showSelection();
        String userSelection = getValidSelection();
        handleUserSelection(userSelection);
    }

    private String getValidSelection() {
        String userSelection = readLine();
        while(inValidSelection(userSelection)){
            this.view.showWrongSelectionInfo();
            userSelection = readLine();
        }
        return userSelection;
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    private boolean inValidSelection(String userSelection) {
        return !(userSelection.equals(StartNewGame) || userSelection.equals(ExitGame));
    }

    private void handleUserSelection(String userSelection){
        if (userSelection.equals(StartNewGame)) {
            this.controller.setHandler(new InitModeHandler(this.model,this.view,this.controller));
            return;
        }
        if(userSelection.equals(ExitGame)) {
            this.view.showEnd();
            this.controller.setHandler(new EndModeHandler());
            return;
        }
    }
}
