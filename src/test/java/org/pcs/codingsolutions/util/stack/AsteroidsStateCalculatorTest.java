package org.pcs.codingsolutions.util.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AsteroidsStateCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetAsteroidsStatesAfterCollisions(int[] asteroidsSizeAndDirections, int[] expected) {
        // when
        int[] actual = AsteroidsStateCalculator.getAsteroidsStatesAfterCollisions(asteroidsSizeAndDirections);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetAsteroidsStatesAfterCollisions() {
        return Stream.of(
                Arguments.of(new int[]{5, 10, -5}, new int[]{5, 10}),
                Arguments.of(new int[]{8, -8}, new int[]{}),
                Arguments.of(new int[]{10, 2, -5}, new int[]{10}),
                Arguments.of(new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2})
        );
    }
}