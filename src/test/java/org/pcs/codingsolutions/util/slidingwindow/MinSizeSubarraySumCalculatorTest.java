package org.pcs.codingsolutions.util.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinSizeSubarraySumCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMinSubArrayLen(int target, int[] nums, int expected) {
        // when
        int actual = MinSizeSubarraySumCalculator.getMinSubArrayLen(target, nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMinSubArrayLen() {
        return Stream.of(
                Arguments.of(7, new int[]{2, 3, 1, 2, 4, 3}, 2),
                Arguments.of(4, new int[]{1, 4, 4}, 1),
                Arguments.of(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0),
                Arguments.of(15, new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}, 8)
        );
    }
}