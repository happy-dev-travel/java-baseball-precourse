package baseball.controller.handlers;

import baseball.model.BaseBallModel;
import baseball.model.UserBallCount;
import baseball.view.BaseBallView;

import java.util.ArrayList;
import java.util.List;

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
            UserBallCount judge = this.model.judge(getUserInputs());
            this.view.showBaseBallCount(judge.getStrike(), judge.getBall());
            this.findAnswer = judge.isAnswer();
        }
    }

    private List<Integer> getUserInputs() {
        this.view.showNextInput();
        char[] chars = readLine().toCharArray();
        return convertUserStringToIntegers(chars);
    }

    private List<Integer> convertUserStringToIntegers(char[] chars) {
        List<Integer> userInputs = new ArrayList<>();
        for (char num : chars) {
            userInputs.add(Character.getNumericValue(num));
        }
        return userInputs;
    }
}
