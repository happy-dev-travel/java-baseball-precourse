package baseball.util;

import baseball.model.AnswerGenerator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomAnswerGenerator implements AnswerGenerator {
    @Override
    public List<Integer> generate(int start, int end, int count) {
        validateRange(start,end);
        validateCount(count);
        return getUniqueNumbers(start, end, count);
    }

    private List<Integer> getUniqueNumbers(int start, int end, int count) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while(uniqueNumbers.size() != count){
            uniqueNumbers.add(Randoms.pickNumberInRange(start, end));
        }
        return new ArrayList<>(uniqueNumbers);
    }

    private void validateCount(int count) {
        if(count != 3){
            throw new IllegalArgumentException("생성하려는 숫자는 3개여야 합니다");
        }
    }

    private void validateRange(int start, int end) {
        if(start < 1){
            throw new IllegalArgumentException("생성할 수 있는 가장 작은 숫자는 1 입니다");
        }

        if(end > 9){
            throw new IllegalArgumentException("생성할 수 있는 가장 큰 숫자는 9 입니다");
        }
    }
}
