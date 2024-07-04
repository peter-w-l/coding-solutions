package org.pcs.codingsolutions.util.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ProvincesNumberDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testCountNumberOfProvinces(int[][] citiesConnectionState, int expected) {
        // given - when
        int actual = ProvincesNumberDeterminer.countNumberOfProvinces(citiesConnectionState);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCountNumberOfProvinces() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 1}}, 2),
                Arguments.of(new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}}, 3),
                Arguments.of(new int[][]{new int[]{1,0,0,1},new int[]{0,1,1,0},new int[]{0,1,1,1},new int[]{1,0,1,1}}, 1)
        );
    }
}