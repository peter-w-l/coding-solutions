package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSquareCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxSquare(char[][] matrix, int expected) {
        // when
        int actual = MaxSquareCalculator.getMaxSquare(matrix);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxSquare() {
        return Stream.of(
                Arguments.of(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}, 4),
                Arguments.of(new char[][]{{'0','1'},{'1','0'}}, 1),
                Arguments.of(new char[][]{{'0'}}, 0)
        );
    }
}