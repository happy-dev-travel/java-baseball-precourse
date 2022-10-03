package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("[요구사항1] \"1,2\"를 ,로 split했을 때 1과 2만 포함하는 배열이 반환되어야 함")
    void test1(){
        String test = "1,2";

        String[] split = test.split(",");

        assertThat(split).containsExactly("1","2");
    }

    @Test
    @DisplayName("[요구사항1] \"1\"을 ,로 split했을 때 1만 포함하는 배열이 반환되어야 함")
    void test2(){
        String test = "1";

        String[] split = test.split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("[요구사항2] \"(1,2)\"에서 괄호()를 제거하고 \"1,2\"가 반환되어야 함(substring활용)")
    void test3(){
        String test = "(1,2)";

        String substring = test.substring(1, test.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,a","1,b","2,c"},delimiter = ',')
    @DisplayName("[요구사항3] \"abc\"가 주어졌을 때 특정 위치의 문자를 올바르게 가져와야 함")
    void test4(Integer index, Character answer){
        String test = "abc";

        char c = test.charAt(index);

        assertThat(c).isEqualTo(answer);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,3})
    @DisplayName("[요구사항3] \"abc\"가 주어졌을 때 특정 위치의 문자를 올바르게 가져와야 함")
    void test4(Integer index){
        String test = "abc";

        assertThatThrownBy(() -> test.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d",index));
    }
}
