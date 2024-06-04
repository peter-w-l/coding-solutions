package org.pcs.codingsolutions.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxConsecutiveOnesCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void getMaxNumberOfOnesWithFlippingNumber(int[] nums, int flippingLimit, int expected) {
        // when
        int actual = MaxConsecutiveOnesCalculator.getMaxNumberOfOnesWithFlippingNumber(nums, flippingLimit);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> getMaxNumberOfOnesWithFlippingNumber() {
        return Stream.of(

                Arguments.of(new int[] {0,0,0,1}, 2, 3),
                Arguments.of(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2, 6),
                Arguments.of(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3, 10)
        );
    }
}