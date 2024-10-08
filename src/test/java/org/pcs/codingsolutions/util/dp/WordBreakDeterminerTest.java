package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WordBreakDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testCanBreakUsingDictionary(String sourceWord, List<String> wordDict, boolean expected) {
        // when
        boolean actual = WordBreakDeterminer.canBreakUsingDictionary(sourceWord, wordDict);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Example 1:
     * <p>
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     * <p>
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * <p>
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     */
    @SuppressWarnings("unused")
    private static Stream<Arguments> testCanBreakUsingDictionary() {
        return Stream.of(
                Arguments.of("leetcode", List.of("leet", "code"), true),
                Arguments.of("applepenapple", List.of("apple", "pen"), true),
                Arguments.of("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }
}