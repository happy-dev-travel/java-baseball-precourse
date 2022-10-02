package baseball;

import baseball.controller.BaseBallController;
import baseball.controller.SimpleBaseBallController;
import baseball.model.AnswerGenerator;
import baseball.model.BaseBallModel;
import baseball.model.SimpleBaseBallModel;
import baseball.util.RandomAnswerGenerator;
import baseball.view.BaseBallView;
import baseball.view.SimpleBaseBallView;

public class Application {
    public static void main(String[] args) {
        AnswerGenerator answerGenerator = new RandomAnswerGenerator();
        BaseBallModel model = new SimpleBaseBallModel(answerGenerator);

        BaseBallView view = new SimpleBaseBallView();

        BaseBallController controller = new SimpleBaseBallController(model,view);
        controller.start();
    }
}
