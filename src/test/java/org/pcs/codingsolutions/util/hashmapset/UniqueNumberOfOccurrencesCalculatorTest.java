package org.pcs.codingsolutions.util.hashmapset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueNumberOfOccurrencesCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testIsNumberOfOccurrencesUnique(int[] array, boolean expected) {
        // when
        var actual = UniqueNumberOfOccurrencesCalculator.isNumberOfOccurrencesUnique(array);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testIsNumberOfOccurrencesUnique() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,1,1,3}, true),
                Arguments.of(new int[] {1,2}, false),
                Arguments.of(new int[] {-3,0,1,-3,1,1,1,-3,10,0}, true)
        );
    }
}