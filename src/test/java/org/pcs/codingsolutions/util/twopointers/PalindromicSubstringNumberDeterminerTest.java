package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromicSubstringNumberDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void countPalindromicSubstrings(String sourceString, int expected) {
        // given - when
        int actual = PalindromicSubstringNumberDeterminer.countPalindromicSubstrings(sourceString);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> countPalindromicSubstrings() {
        return Stream.of(
                Arguments.of("abc", 3),
                Arguments.of("aaa", 6),
                Arguments.of("aba", 4)
        );
    }
}