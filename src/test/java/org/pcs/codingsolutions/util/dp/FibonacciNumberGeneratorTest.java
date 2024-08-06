package org.pcs.codingsolutions.util.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FibonacciNumberGeneratorTest {

    @ParameterizedTest
    @MethodSource
    void testGenerate(int input, int expected) {
        // when
        int actual = FibonacciNumberGenerator.generate(input);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGenerate() {
        return Stream.of(
//                Arguments.of(2, 1),
//                Arguments.of(3, 2),
                Arguments.of(4, 3)
        );
    }
}