package baseball.model;

import baseball.util.RandomAnswerGenerator;

import java.util.List;

public class SimpleBaseBallModelImpl implements SimpleBaseBallModel{

    private List<Integer> answers;
    private final AnswerGenerator answerGenerator;

    public SimpleBaseBallModelImpl(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    @Override
    public void init() {
        answers = answerGenerator.generate(1,9,3);
    }
}
