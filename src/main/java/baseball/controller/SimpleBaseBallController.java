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
        runGame();
    }

    private void runGame() {
        List<Integer> userInputs = getUserInputs();
        UserBallCount judge = this.model.judge(userInputs);
        this.view.showBaseBallCount(judge.getStrike(), judge.getBall());
        goNext(judge);
    }

    private void goNext(UserBallCount judge) {
        if (judge.isAnswer()) {
            showSuccess();
        } else {
            runGame();
        }
    }

    private void showSuccess() {
        this.view.showSuccess();
        handleUserInputForNextGame();
    }

    private void handleUserInputForNextGame() {
        String input = readLine();
        if (input.equals("1")) {
            start();
        } else if(input.equals("2")){
            this.view.showEnd();
        } else {
            handleUserInputForNextGame();
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
