package org.pcs.codingsolutions.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxNumberOfPairsCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxNumberOfPairsWithSum(int[] array, int pairSum, double expected) {
        // when
        double actual = MaxNumberOfPairsCalculator.getMaxNumberOfPairsWithSum(array, pairSum);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxNumberOfPairsWithSum() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, 5, 2),
                Arguments.of(new int[] {3,1,3,4,3}, 6, 1)
        );
    }
}