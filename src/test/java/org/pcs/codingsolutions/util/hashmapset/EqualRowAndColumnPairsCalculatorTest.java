package org.pcs.codingsolutions.util.hashmapset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EqualRowAndColumnPairsCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testAreEqualPairs(int[][] grid, int expected) {
        // when
        var actual = EqualRowAndColumnPairsCalculator.areEqualPairs(grid);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testAreEqualPairs() {
        return Stream.of(
                Arguments.of(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1),
                Arguments.of(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3),
                Arguments.of(new int[][]{{1, 2, 3, 4}, {2, 1, 7, 5}, {3, 0, 9, 6}, {4, 5, 6, 7}}, 2)
        );
    }
}