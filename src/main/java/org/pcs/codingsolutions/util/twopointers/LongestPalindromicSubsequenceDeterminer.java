package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence
 * by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
@UtilityClass
public class LongestPalindromicSubsequenceDeterminer {
    public int longestPalindromeSubseq(String sourceString) {
        int sourceStringLength = sourceString.length();
        char[] sourceStringChars = sourceString.toCharArray();
        int[][] results = new int[sourceStringLength][sourceStringLength];
        for (int i = sourceStringLength - 1; i >= 0; i--) {
            results[i][i] = 1; // one character substring is a palindrome as well
            for (int j = i + 1; j < sourceStringLength; j ++) {
                if (sourceStringChars[i] == sourceStringChars[j]) {
                    results[i][j] = results[i + 1][j - 1] + 2;
                } else {
                    results[i][j] = Math.max(results[i + 1][j], results[i][j - 1]);
                }
            }
        }

        return results[0][sourceStringLength - 1];
    }
}
