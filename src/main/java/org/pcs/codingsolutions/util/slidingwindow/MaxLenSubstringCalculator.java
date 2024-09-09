package org.pcs.codingsolutions.util.slidingwindow;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for:
 * <p>
 * Given a string s, return the maximum length of a  substring such that it contains at most two occurrences of each character.
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 100
 * s consists only of lowercase English letters.
 */
@UtilityClass
public class MaxLenSubstringCalculator {
    public int getWithMaxTwoCharOccurrences(String sourceString) {
        char[] sourceStringChars = sourceString.toCharArray();
        Map<Character, Integer> charToOccurrences = new HashMap<>();
        int maxLen = 0;
        int beginIndex = 0;
        for (int endIndex = 0; endIndex < sourceStringChars.length; endIndex++) {
            Character currentChar = sourceStringChars[endIndex];
            charToOccurrences.merge(sourceStringChars[endIndex], 1, Integer::sum);
            while (charToOccurrences.get(currentChar) > 2) {
                charToOccurrences.merge(sourceStringChars[beginIndex], -1, Integer::sum);
                beginIndex++;
            }
            maxLen = Math.max(endIndex - beginIndex + 1, maxLen);
        }

        return maxLen;
    }
}
