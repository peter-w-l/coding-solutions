package org.pcs.codingsolutions.util.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxLenSubstringCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetWithMaxTwoCharOccurrences(String input, int expected) {
        // when
        int actual = MaxLenSubstringCalculator.getWithMaxTwoCharOccurrences(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetWithMaxTwoCharOccurrences() {
        return Stream.of(
                Arguments.of("bcbbbcba", 4),
                Arguments.of("aaaa", 2),
                Arguments.of("acedc", 5),
                Arguments.of("eebadadbfa", 9)
        );
    }
}