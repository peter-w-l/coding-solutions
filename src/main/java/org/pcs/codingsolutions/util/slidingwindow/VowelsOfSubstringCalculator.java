package org.pcs.codingsolutions.util.slidingwindow;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Solution for:
 *
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class VowelsOfSubstringCalculator {
    public static int getMaxNumberOfVowelsInSubstring(String source, int substringLength) {
        int stringLength = source.length();
        int numberOfVowels = 0;
        int maxNumberOfVowels = 0;
        int leftIndex = 0;
        for (int rightIndex = 0; rightIndex < stringLength; rightIndex ++) {
            if (isVowel(source.charAt(rightIndex))) {
                numberOfVowels ++;
            }
            if (rightIndex - leftIndex + 1 == substringLength) {
                maxNumberOfVowels = Math.max(maxNumberOfVowels, numberOfVowels);
                if (isVowel(source.charAt(leftIndex))) {
                    numberOfVowels --;
                }
                leftIndex ++;
            }
        }
        return maxNumberOfVowels; // time complexity is O(N), space complexity is O(1).
    }

    private static boolean isVowel(char ch) {
        return ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}