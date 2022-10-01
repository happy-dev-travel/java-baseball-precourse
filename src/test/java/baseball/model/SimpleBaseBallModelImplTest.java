package baseball.model;

import baseball.util.RandomAnswerGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SimpleBaseBallModelImplTest {

    @Mock
    private RandomAnswerGenerator generator;

    @InjectMocks
    private SimpleBaseBallModelImpl model;

    @BeforeEach
    void prepare(){
        given(generator.generate(1,9,3)).willReturn(Arrays.asList(
                1,3,5
        ));
        model.init();
    }

    @DisplayName("[positive] 스트라이크 갯수를 바르게 판정함")
    @ParameterizedTest
    @CsvSource(value = {"1,3,5,3","1,2,4,1","1,5,3,1","5,1,3,0","7,8,9,0"},delimiter = ',')
    void judge(Integer answer1,Integer answer2,Integer answer3,Integer strike) {

        UserBallCount judge = model.judge(Arrays.asList(answer1, answer2, answer3));

        assertThat(judge.getStrike()).isEqualTo(strike);
    }

    @DisplayName("[positive] 볼 갯수를 바르게 판정함")
    @ParameterizedTest
    @CsvSource(value = {"1,3,5,0","1,2,4,0","1,5,3,2","5,1,3,3","7,8,9,0"},delimiter = ',')
    void judge2(Integer answer1,Integer answer2,Integer answer3,Integer ball) {

        UserBallCount judge = model.judge(Arrays.asList(answer1, answer2, answer3));

        assertThat(judge.getBall()).isEqualTo(ball);
    }
}