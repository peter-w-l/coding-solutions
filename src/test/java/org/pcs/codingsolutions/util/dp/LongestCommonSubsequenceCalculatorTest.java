package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestCommonSubsequenceCalculatorTest {

    @ParameterizedTest
    @MethodSource("testGetLongestCommonSubsequence")
    void testGetLongestCommonSubsequenceTopDown(String sourceString1, String sourceString2, int expected) {
        // given
        char[] sourceString1Chars = sourceString1.toCharArray();
        char[] sourceString2Chars = sourceString2.toCharArray();
        int[][] cache = new int[sourceString1Chars.length][sourceString2Chars.length];
        Arrays.stream(cache).forEach(lineCache -> Arrays.fill(lineCache, -1));

        // when
        int actual = LongestCommonSubsequenceCalculator.getLongestCommonSubsequenceTopDown(
                sourceString1Chars.length - 1,
                sourceString1Chars,
                sourceString2Chars.length - 1,
                sourceString2Chars,
                cache);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testGetLongestCommonSubsequence")
    void testGetLongestCommonSubsequenceBottomUp(String sourceString1, String sourceString2, int expected) {
        // when
        int actual = LongestCommonSubsequenceCalculator.getLongestCommonSubsequenceBottomUp(sourceString1, sourceString2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetLongestCommonSubsequence() {
        return Stream.of(
                Arguments.of("abcde", "ace", 3),
                Arguments.of("abc", "abc", 3),
                Arguments.of("abc", "dce", 1),
                Arguments.of("abc", "def", 0),
                Arguments.of("bl", "yby", 1),
                Arguments.of("abdc", "bbc", 2),
                Arguments.of("ezupkr", "ubmrapg", 2),
                Arguments.of("bsbininm", "jmjkbkjkv", 1)
        );
    }
}