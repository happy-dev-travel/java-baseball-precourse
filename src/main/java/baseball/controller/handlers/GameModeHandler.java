package baseball.controller.handlers;

import baseball.controller.BaseBallController;
import baseball.model.BaseBallModel;
import baseball.model.UserBallCount;
import baseball.view.BaseBallView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameModeHandler implements ModeHandler {
    private final BaseBallController controller;
    private final BaseBallModel model;
    private final BaseBallView view;
    private boolean findAnswer;

    public GameModeHandler(BaseBallModel model,BaseBallView view,BaseBallController baseBallController) {
        this.controller = baseBallController;
        this.model = model;
        this.view = view;
    }

    @Override
    public void process() {
        init();
        run();
        this.view.showSuccess();
        this.controller.setHandler(new SelectionModeHandler(this.model,this.view,this.controller));
    }

    private void init() {
        this.model.init();
        this.findAnswer = false;
    }

    private void run() {
        while(!this.findAnswer){
            this.view.showNextInput();
            UserBallCount judge = this.model.judge(readLine());
            this.view.showBaseBallCount(judge.getStrike(), judge.getBall());
            this.findAnswer = judge.isAnswer();
        }
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
