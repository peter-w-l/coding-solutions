package org.pcs.codingsolutions.util.slidingwindow;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * A string is good if there are no repeated characters.
 * Given a string s, return the number of good substrings of length three in s.
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 * A substring is a contiguous sequence of characters in a string.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of lowercase English letters.
 */
@UtilityClass
public class SubstringWithUniqueCharsCalculator {
    public int countGoodSubstrings(String sourceString) {
        int sourceStringLength = sourceString.length();
        char[] sourceStringChars = sourceString.toCharArray();
        int numberOfGoodSubstrings = 0;

        for (int i = 0; i < sourceStringLength - 2; i++) {
            if (sourceStringChars[i] != sourceStringChars[i + 1]
                    && sourceStringChars[i + 1] != sourceStringChars[i + 2]
                    && sourceStringChars[i] != sourceStringChars[i + 2]) {
                numberOfGoodSubstrings++;
            }
        }

        return numberOfGoodSubstrings;
    }
}
