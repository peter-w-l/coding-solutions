package org.pcs.codingsolutions.util.prefixsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HighestAltitudeCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetHighestAltitude(int[] array, int expected) {
        // when
        int actual = HighestAltitudeCalculator.getHighestAltitude(array);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetHighestAltitude() {
        return Stream.of(
                Arguments.of(new int[] {-5,1,5,0,-7}, 1),
                Arguments.of(new int[] {-4,-3,-2,-1,4,3,2}, 0)
        );
    }
}