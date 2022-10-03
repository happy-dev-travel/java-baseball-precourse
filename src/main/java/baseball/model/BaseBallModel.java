package baseball.model;

public interface BaseBallModel {
    void init();
    UserBallCount judge(String userAnswer);
    String getAnswer();
}
