package baseball.model;

import java.util.HashSet;
import java.util.List;

public class SimpleBaseBallModelImpl implements BaseBallModel {

    private List<Integer> answers;
    private final AnswerGenerator answerGenerator;

    public SimpleBaseBallModelImpl(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    @Override
    public void init() {
        answers = answerGenerator.generate(1,9,3);
    }

    @Override
    public UserBallCount judge(final List<Integer> userAnswers) {
        validateUserAnswers(userAnswers);
        Integer countInAnswer = countValidUserAnswer(userAnswers);
        if(countInAnswer == 0){
            return new UserBallCount(0,0);
        }
        Integer strikes = countStrikes(userAnswers);
        Integer ball = countInAnswer - strikes;
        return new UserBallCount(strikes,ball);
    }

    private Integer countStrikes(List<Integer> userAnswers) {
        int strikes = 0;
        for (int index = 0; index < answers.size(); index++) {
            Integer answer = answers.get(index);
            Integer user = userAnswers.get(index);
            strikes += answer.equals(user) ? 1 : 0;
        }
        return strikes;
    }

    private void validateUserAnswers(List<Integer> userAnswers) {
        if(userAnswers == null || userAnswers.size() == 0){
            throw new IllegalArgumentException("사용자 입력이 비어있을 수 없습니다");
        }
        if(userAnswers.size() != this.answers.size()){
            throw new IllegalArgumentException("사용자는 3개의 숫자를 입력해야 합니다");
        }
        if(userAnswers.size() != new HashSet<>(userAnswers).size()){
            throw new IllegalArgumentException("사용자 입력에 중복된 숫자가 존재합니다");
        }
    }

    private Integer countValidUserAnswer(List<Integer> userAnswers) {
        int numberCountInAnswer = 0;
        for (Integer answer : answers) {
            numberCountInAnswer += userAnswers.contains(answer) ? 1 : 0;
        }
        return numberCountInAnswer;
    }
}
