package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerGeneratorTest {

    private RandomAnswerGenerator generator;

    @BeforeEach
    void prepare(){
        generator = new RandomAnswerGenerator();
    }

    @Test
    @DisplayName("[positive] 1~9사이의 중복되지 않은 숫자 3개를 생성함")
    void test1(){
        List<Integer> answers = generator.generate(1, 9, 3);

        assertThat(answers.size()).isEqualTo(3);
        assertThat(new HashSet<>(answers).size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,4})
    @DisplayName("[negative] 생성하려는 숫자가 3개가 아니면 exception발생")
    void test2(){
        assertThatThrownBy(() -> generator.generate(1, 9, 4)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints={Integer.MIN_VALUE,0})
    @DisplayName("[negative] 생성하려는 가장 작은 숫자가 1보다 작으면 exception발생")
    void test3(){
        assertThatThrownBy(() -> generator.generate(0, 9, 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints={10,Integer.MAX_VALUE})
    @DisplayName("[negative] 생성하려는 가장 큰 숫자가 9보다 크면 exception발생")
    void test4(){
        assertThatThrownBy(() -> generator.generate(1, 10, 3)).isInstanceOf(IllegalArgumentException.class);
    }
}