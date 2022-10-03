package baseball.controller.handlers;

import baseball.controller.BaseBallController;
import baseball.model.BaseBallModel;
import baseball.view.BaseBallView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputModeHandler implements ModeHandler {

    private final BaseBallModel model;
    private final BaseBallView view;
    private final BaseBallController controller;

    public InputModeHandler(BaseBallModel model, BaseBallView view, BaseBallController controller) {
        this.model = model;
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void process() {
        this.view.showRequestNextInput();
        String userInput = readLine();
        if(isExitCharacterDuringGame(userInput)) {
            this.view.showAnswer(this.model.getAnswer());
            this.controller.setHandler(new SelectionModeHandler(model,view,controller));
            return;
        }
        this.controller.setHandler(new JudgeModeHandler(model,view, controller,userInput));
    }

    private boolean isExitCharacterDuringGame(String s) {
        return s != null && (s.equals("Q") || s.equals("q"));
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
