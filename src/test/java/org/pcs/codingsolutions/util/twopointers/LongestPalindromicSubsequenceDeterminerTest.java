package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromicSubsequenceDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testLongestPalindromeSubseq(String sourceString, int expected) {
        // when
        int actual = LongestPalindromicSubsequenceDeterminer.longestPalindromeSubseq(sourceString);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testLongestPalindromeSubseq() {
        return Stream.of(
                Arguments.of("bbbab", 4),
                Arguments.of("cbbd", 2),
                Arguments.of("a", 1),
                Arguments.of("ab", 1)
        );
    }

}