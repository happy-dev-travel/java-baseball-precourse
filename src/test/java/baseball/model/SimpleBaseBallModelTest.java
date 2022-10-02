package baseball.model;

import baseball.util.RandomAnswerGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

class SimpleBaseBallModelTest {

    @Mock
    private RandomAnswerGenerator generator;

    @InjectMocks
    private SimpleBaseBallModel model;

    @BeforeEach
    void prepare(){
        MockitoAnnotations.openMocks(this);
        given(generator.generate(1,9,3)).willReturn(Arrays.asList(
                1,3,5
        ));
        model.init();
    }

    @DisplayName("[positive] 스트라이크 갯수를 바르게 판정함")
    @ParameterizedTest
    @CsvSource(value = {"135,3","124,1","153,1","513,0","789,0"},delimiter = ',')
    void judge(String answer,Integer strike) {

        UserBallCount judge = model.judge(answer);

        assertThat(judge.getStrike()).isEqualTo(strike);
    }

    @DisplayName("[positive] 볼 갯수를 바르게 판정함")
    @ParameterizedTest
    @CsvSource(value = {"135,0","124,0","153,2","513,3","789,0"},delimiter = ',')
    void judge2(String answer,Integer ball) {

        UserBallCount judge = model.judge(answer);

        assertThat(judge.getBall()).isEqualTo(ball);
    }

    @DisplayName("[negative] 비정상 입력 시 exception발생")
    @ParameterizedTest
    @CsvSource(value = {"ㅁㅁ","ㅁㅁㅁ","qqq","QQQ","''","1","12","1234","111","★","' '","'   '"})
    void judge3(String answer) {
        assertThatThrownBy(()->model.judge(answer)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[negative] 비정상 입력(null) 시 exception발생")
    @Test
    void judge4() {
        assertThatThrownBy(()->model.judge(null)).isInstanceOf(IllegalArgumentException.class);
    }
}