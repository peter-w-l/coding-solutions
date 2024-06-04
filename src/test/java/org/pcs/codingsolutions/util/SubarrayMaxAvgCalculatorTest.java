package org.pcs.codingsolutions.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubarrayMaxAvgCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testFindMaxAvgInSubarraysWithLength(int[] array, int subarrayLength, double expected) {
        // when
        double actual = SubarrayMaxAvgCalculator.findMaxAvgInSubarraysWithLength(array, subarrayLength);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testFindMaxAvgInSubarraysWithLength() {
        return Stream.of(
                Arguments.of(new int[] {1,12,-5,-6,50,3}, 4, 12.75),
                Arguments.of(new int[] {5}, 1, 5.0)
        );
    }
}