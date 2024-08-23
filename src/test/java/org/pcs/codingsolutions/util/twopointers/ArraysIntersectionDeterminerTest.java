package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ArraysIntersectionDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testGetIntersection(int[] array1, int[] array2, int[] expected) {
        // when
        int[] actual = ArraysIntersectionDeterminer.getIntersection(array1, array2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetIntersection() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2}),
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
        );
    }
}