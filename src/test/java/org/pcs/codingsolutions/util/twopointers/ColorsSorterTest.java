package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ColorsSorterTest {

    @ParameterizedTest
    @MethodSource
    void testFindDuplicate(int[] heightArray, int[] expected) {
        // when
        ColorsSorter.sortColors(heightArray);

        // then
        assertThat(heightArray).containsExactly(expected);
    }

    private static Stream<Arguments> testFindDuplicate() {
        return Stream.of(
                Arguments.of(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.of(new int[]{2, 0, 1}, new int[]{0, 1, 2}),
                Arguments.of(new int[]{1, 2, 0}, new int[]{0, 1, 2})
        );
    }
}