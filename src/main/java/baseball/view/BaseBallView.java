package baseball.view;

public interface BaseBallView {
    void showNextInput();
    void showBaseBallCount(int strike,int ball);
    void showSuccess();
    void showSelection();
    void showEnd();
    void showAnswer(String answer);
    void showWrongSelectionInfo();
}
