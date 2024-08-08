package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortedVowelStringsCounterTest {

    @ParameterizedTest
    @MethodSource
    void testCountDistinctSortedVowelStringsOfLength(int input, int expected) {
        // when
        int actual = SortedVowelStringsCounter.countDistinctSortedVowelStringsOfLength(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCountDistinctSortedVowelStringsOfLength() {
        return Stream.of(
                Arguments.of(1, 5),
                Arguments.of(2, 15),
                Arguments.of(33, 66045)
        );
    }
}