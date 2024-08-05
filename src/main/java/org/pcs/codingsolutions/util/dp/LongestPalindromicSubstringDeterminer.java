package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
@UtilityClass
public class LongestPalindromicSubstringDeterminer {
    public String getLongestPalindromicSubstring(String sourceString) {
        int sourceStringLength = sourceString.length();
        char[] sourceStringChars = sourceString.toCharArray();
        int beginIndex = 0;
        int endIndex = 0;
        int max = 1;
        boolean[][] palindromeMemorization = new boolean[sourceStringLength][sourceStringLength];
        for (int i = sourceStringLength - 1; i >= 0; i--) {
            palindromeMemorization[i][i] = true;
            for (int j = i + 1; j < sourceStringLength; j++) {
                if ((sourceStringChars[i] == sourceStringChars[j])
                        && ((j == i + 1) || palindromeMemorization[i + 1][j - 1])) {
                    palindromeMemorization[i][j] = true;
                    int substringLength = j - i + 1;
                    if (max < substringLength) {
                        max = substringLength;
                        beginIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return sourceString.substring(beginIndex, endIndex + 1);
    }
}
