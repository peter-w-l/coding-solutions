package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TribonacciNumberCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetTribonacciNumber(int input, int expected) {
        // when
        int actual = TribonacciNumberCalculator.getTribonacciNumber(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetTribonacciNumber() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(25, 1389537)
        );
    }
}