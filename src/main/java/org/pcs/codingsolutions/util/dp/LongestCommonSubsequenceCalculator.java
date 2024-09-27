package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * Constraints:
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
@UtilityClass
public class LongestCommonSubsequenceCalculator {
    public int getLongestCommonSubsequenceBottomUp(String sourceString1, String sourceString2) {
        char[] sourceString1Chars = sourceString1.toCharArray();
        char[] sourceString2Chars = sourceString2.toCharArray();
        int[][] cache = new int[sourceString1Chars.length + 1][sourceString2Chars.length + 1];

        for (int sourceString1Index = 1; sourceString1Index <= sourceString1Chars.length; sourceString1Index++) {
            for (int sourceString2Index = 1; sourceString2Index <= sourceString2Chars.length; sourceString2Index++) {

                if (sourceString1Chars[sourceString1Index - 1] == sourceString2Chars[sourceString2Index - 1]) {
                    cache[sourceString1Index][sourceString2Index] = cache[sourceString1Index - 1][sourceString2Index - 1] + 1;
                } else {
                    cache[sourceString1Index][sourceString2Index] = Math.max(
                            cache[sourceString1Index - 1][sourceString2Index],
                            cache[sourceString1Index][sourceString2Index - 1]);
                }
            }
        }

        return cache[sourceString1Chars.length][sourceString2Chars.length];
    }

    public int getLongestCommonSubsequenceTopDown(int sourceString1Index,
                                            char[] sourceString1Chars,
                                            int sourceString2Index,
                                            char[] sourceString2Chars,
                                            int[][] cache) {
        if (sourceString1Index == -1 || sourceString2Index == -1) {
            return 0;
        }
        if (cache[sourceString1Index][sourceString2Index] != -1) {
            return cache[sourceString1Index][sourceString2Index];
        }
        int longestCommonSubsequence;
        if (sourceString1Chars[sourceString1Index] == sourceString2Chars[sourceString2Index]) {
            longestCommonSubsequence = getLongestCommonSubsequenceTopDown(sourceString1Index - 1,
                    sourceString1Chars,
                    sourceString2Index - 1,
                    sourceString2Chars,
                    cache) + 1;
        } else {
            longestCommonSubsequence = Math.max(
                    getLongestCommonSubsequenceTopDown(sourceString1Index - 1,
                            sourceString1Chars,
                            sourceString2Index,
                            sourceString2Chars,
                            cache),
                    getLongestCommonSubsequenceTopDown(sourceString1Index,
                            sourceString1Chars,
                            sourceString2Index - 1,
                            sourceString2Chars,
                            cache));
        }
        cache[sourceString1Index][sourceString2Index] = longestCommonSubsequence;
        return longestCommonSubsequence;
    }
}
