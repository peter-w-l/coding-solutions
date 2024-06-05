package org.pcs.codingsolutions.util.prefixsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PivotIndexCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetPivotIndex(int[] array, int expected) {
        // when
        int actual = PivotIndexCalculator.getPivotIndex(array);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetPivotIndex() {
        return Stream.of(
                Arguments.of(new int[] {1,7,3,6,5,6}, 3),
                Arguments.of(new int[] {1,2,3}, -1),
                Arguments.of(new int[] {2,1,-1}, 0)
        );
    }
}