package baseball.controller.handlers;

import baseball.model.BaseBallModel;
import baseball.model.UserBallCount;
import baseball.view.BaseBallView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameModeHandler implements ModeHandler {
    private final BaseBallModel model;
    private final BaseBallView view;
    private boolean findAnswer;

    public GameModeHandler(BaseBallModel model, BaseBallView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public GameStatus process() {
        init();
        run();
        return new GameStatus(true,true);
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
}
