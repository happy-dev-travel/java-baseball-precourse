package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("[요구사항1] Set의 size는 3이 되어야 함")
    void test1(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("[요구사항2] ValueSource의 값을 포함하여야 함")
    void test2(Integer value){
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"},delimiter = ',')
    @DisplayName("[요구사항3] 1,2,3은 포함하고, 4,5는 포함하지 않아야 함")
    void test3(Integer value,Boolean result){
        assertThat(numbers.contains(value)).isEqualTo(result);
    }

    @Test
    @DisplayName("[AssertJ 참고] doesNotContain API")
    void test4(){
        assertThat(numbers).contains(1,2,3).doesNotContain(4,5);
    }
    @Test
    @DisplayName("[AssertJ 참고] as API - 테스트 결과 출력 보조")
    void test5(){
        assertThat(numbers).as("4,5만 포함하면 안됨").contains(1,2,3).doesNotContain(4,5);
    }
}
