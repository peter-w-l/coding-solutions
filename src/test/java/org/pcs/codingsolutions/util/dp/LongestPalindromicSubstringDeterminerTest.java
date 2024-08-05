package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromicSubstringDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testGetLongestPalindromicSubstring(String input, String expected) {
        // when
        String actual = LongestPalindromicSubstringDeterminer.getLongestPalindromicSubstring(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetLongestPalindromicSubstring() {
        return Stream.of(
                Arguments.of("babad", "aba"),
                Arguments.of("cbbd", "bb")
        );
    }
}