package baseball.model;

import java.util.List;

public interface AnswerGenerator {
    List<Integer> generate(int start, int end, int count);
}
