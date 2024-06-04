package org.pcs.codingsolutions.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubarrayAfterDeletingCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxArea(int[] array, int expected) {
        // when
        int actual = LongestSubarrayAfterDeletingCalculator.getLongestSubarrayAfterDeletingOne(array);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxArea() {
        return Stream.of(
                Arguments.of(new int[] {1,1,0,1}, 3),
                Arguments.of(new int[] {0,1,1,1,0,1,1,0,1}, 5),
                Arguments.of(new int[] {1,1,1}, 2)
        );
    }
}