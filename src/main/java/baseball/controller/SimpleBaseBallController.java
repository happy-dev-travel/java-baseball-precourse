package baseball.controller;

import baseball.model.BaseBallModel;
import baseball.model.UserBallCount;
import baseball.view.BaseBallView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SimpleBaseBallController implements BaseBallController{

    private final BaseBallModel model;
    private final BaseBallView view;

    public SimpleBaseBallController(BaseBallModel model, BaseBallView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void start() {
        this.model.init();

        while(true){
            List<Integer> userInputs = getUserInputs();
            UserBallCount judge = this.model.judge(userInputs);
            this.view.showBaseBallCount(judge.getStrike(), judge.getBall());
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
