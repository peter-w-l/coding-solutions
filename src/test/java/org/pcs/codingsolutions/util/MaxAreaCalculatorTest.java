package org.pcs.codingsolutions.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxAreaCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxArea(int[] heightArray, int expected) {
        // when
        int actual = MaxAreaCalculator.getMaxArea(heightArray);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxArea() {
        return Stream.of(
                Arguments.of(new int[] {1,8,6,2,5,4,8,3,7}, 49),
                Arguments.of(new int[] {1,1}, 1)
        );
    }
}