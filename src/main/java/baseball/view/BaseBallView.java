package baseball.view;

public interface BaseBallView {
    void showRequestNextInput();
    void showBaseBallCount(int strike,int ball);
    void showSuccess();
    void showSelection();
    void showEnd();
    void showAnswer(String answer);
    void showWrongSelectionInfo();
}
