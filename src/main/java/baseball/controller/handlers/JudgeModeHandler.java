package baseball.controller.handlers;

import baseball.controller.BaseBallController;
import baseball.model.BaseBallModel;
import baseball.model.UserBallCount;
import baseball.view.BaseBallView;

public class JudgeModeHandler implements ModeHandler {
    private final BaseBallController controller;
    private final BaseBallModel model;
    private final BaseBallView view;
    private final String userInput;

    public JudgeModeHandler(BaseBallModel model, BaseBallView view, BaseBallController baseBallController,String userInput) {
        this.controller = baseBallController;
        this.model = model;
        this.view = view;
        this.userInput = userInput;
    }

    @Override
    public void process() {
        UserBallCount judge = getJudge();
        if(judge.isAnswer()){
            this.view.showSuccess();
            this.controller.setHandler(new SelectionModeHandler(this.model,this.view,this.controller));
            return;
        }
        this.controller.setHandler(new InputModeHandler(this.model,this.view,this.controller));
    }

    private UserBallCount getJudge() {
        UserBallCount judge = this.model.judge(this.userInput);
        this.view.showBaseBallCount(judge.getStrike(), judge.getBall());
        return judge;
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
