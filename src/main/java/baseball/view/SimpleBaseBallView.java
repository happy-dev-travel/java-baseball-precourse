package baseball.view;

public class SimpleBaseBallView implements BaseBallView {
    @Override
    public void showNextInput() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    @Override
    public void showBaseBallCount(int strike, int ball) {
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
            return;
        }
        printBallCount(strike, ball);
    }

    private void printBallCount(int strike, int ball) {
        String strikeFormat = String.format("%d스트라이크", strike);
        String ballFormat = String.format("%d볼", ball);
        if(strike == 0){
            System.out.println(ballFormat);
        } else if (ball == 0) {
            System.out.println(strikeFormat);
        } else {
            System.out.printf("%s %s%n",ballFormat,strikeFormat);
        }
    }

    @Override
    public void showSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    @Override
    public void showEnd() {
        System.out.println("또 만나요");
    }
}
