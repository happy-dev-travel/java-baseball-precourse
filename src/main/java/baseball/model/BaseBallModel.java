package baseball.model;

import java.util.List;

public interface BaseBallModel {
    void init();
    UserBallCount judge(String userAnswer);
}
