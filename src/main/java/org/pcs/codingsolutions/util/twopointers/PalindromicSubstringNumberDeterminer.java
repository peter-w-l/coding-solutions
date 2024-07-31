package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
@UtilityClass
public class PalindromicSubstringNumberDeterminer {
    public int countPalindromicSubstrings(String sourceString) {
        int sourceStringLength = sourceString.length();
        int palindromicSubstringsNumber = sourceStringLength; // every substring of length 1 is palindrome
        for (int i = 0; i < sourceStringLength; i++) {
            palindromicSubstringsNumber += countPalindromesExpanding(i, i + 1, sourceString, sourceStringLength); //  check substrings of even length
            palindromicSubstringsNumber += countPalindromesExpanding(i - 1, i + 1, sourceString, sourceStringLength); // odd
        }

        return palindromicSubstringsNumber;
    }

    private int countPalindromesExpanding(int beginIndex, int endIndex, String sourceString, int sourceStringLength) {
        if (beginIndex < 0
                || endIndex >= sourceStringLength
                || sourceString.charAt(beginIndex) != sourceString.charAt(endIndex)) {
            return 0;
        }
        return countPalindromesExpanding(beginIndex - 1, endIndex + 1, sourceString, sourceStringLength) + 1;
    }
}
