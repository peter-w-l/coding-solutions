package org.pcs.codingsolutions.util.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubstringWithUniqueCharsCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testCountGoodSubstrings(String input, int expected) {
        // when
        int actual = SubstringWithUniqueCharsCalculator.countGoodSubstrings(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCountGoodSubstrings() {
        return Stream.of(
                Arguments.of("xyzzaz", 1),
                Arguments.of("aababcabc", 4)
        );
    }
}