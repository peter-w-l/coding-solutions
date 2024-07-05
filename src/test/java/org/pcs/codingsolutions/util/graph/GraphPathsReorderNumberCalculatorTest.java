package org.pcs.codingsolutions.util.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GraphPathsReorderNumberCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMinPathReorderNumber(int numberOfCities, int[][] citiesConnectionState, int expected) {
        // given - when
        int actual = GraphPathsReorderNumberCalculator.getMinPathReorderNumber(numberOfCities, citiesConnectionState);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMinPathReorderNumber() {
        return Stream.of(
                Arguments.of(6, new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 3},
                        new int[]{2, 3},
                        new int[]{4, 0},
                        new int[]{4, 5}}, 3),
                Arguments.of(5, new int[][]{
                        new int[]{1, 0},
                        new int[]{1, 2},
                        new int[]{3, 2},
                        new int[]{3, 4}}, 2),
                Arguments.of(3, new int[][]{
                        new int[]{1, 0},
                        new int[]{2, 0}}, 0)
        );
    }
}