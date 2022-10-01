package baseball.model;

import java.util.List;

public interface SimpleBaseBallModel {
    void init();

    UserBallCount judge(final List<Integer> userAnswers);
}
