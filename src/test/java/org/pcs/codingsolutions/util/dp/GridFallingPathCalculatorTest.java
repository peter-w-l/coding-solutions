package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GridFallingPathCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMinFallingPathSum(int[][] input, int expected) {
        // when
        int actual = GridFallingPathCalculator.getMinFallingPathSum(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> testGetMinFallingPathSum() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 13),
                Arguments.of(new int[][]{{-19, 57}, {-40, -5}}, -59)
        );
    }
}