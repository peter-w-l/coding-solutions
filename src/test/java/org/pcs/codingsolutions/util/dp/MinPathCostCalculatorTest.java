package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinPathCostCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetNumberOfDifferentWaysToReach(int[] input, int expected) {
        // when
        int actual = MinPathCostCalculator.getMinPathCost(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetNumberOfDifferentWaysToReach() {
        return Stream.of(
                Arguments.of(new int[]{10,15,20}, 15),
                Arguments.of(new int[]{1,100,1,1,1,100,1,1,100,1}, 6)
        );
    }
}