package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ArraySorterByFrequencyTest {

    @ParameterizedTest
    @MethodSource
    void testSortByFrequency(int[] heightArray, int[] expected) {
        // when
        int[] actual = ArraySorterByFrequency.sortByFrequency(heightArray);

        // then
        assertThat(actual).containsExactly(expected);
    }

    private static Stream<Arguments> testSortByFrequency() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 2, 2, 3}, new int[]{3, 1, 1, 2, 2, 2}),
                Arguments.of(new int[]{2, 3, 1, 3, 2}, new int[]{1, 3, 3, 2, 2}),
                Arguments.of(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}, new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1})
        );
    }
}