package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GridPathCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetUniquePathNumber(int[][] obstacleGrid, int expected) {
        // when
        int actual = GridPathCalculator.getUniquePathNumber(obstacleGrid);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> testGetUniquePathNumber() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, 2)
        );
    }
}