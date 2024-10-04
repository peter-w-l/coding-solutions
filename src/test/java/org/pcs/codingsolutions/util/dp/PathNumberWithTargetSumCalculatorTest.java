package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PathNumberWithTargetSumCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetPathNumberWithTargetSum(int[] numbers, int targetSum, int expected) {
        // when
        int actual = PathNumberWithTargetSumCalculator.getPathNumberWithTargetSum(numbers, targetSum);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> testGetPathNumberWithTargetSum() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 3, 5),
                Arguments.of(new int[]{1}, 1, 1)
        );
    }
}