package baseball.model;

public class UserBallCount {
    private final Integer strike;
    private final Integer ball;

    public UserBallCount(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike(){
        return this.strike;
    }

    public Integer getBall(){
        return this.ball;
    }

    public boolean isAnswer() {
        return getStrike().equals(3);
    }
}
