package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u)
 * and are lexicographically sorted.
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 */
@UtilityClass
public class SortedVowelStringsCounter {
    public int countDistinctSortedVowelStringsOfLength(int n) {
        return countDistinctSortedVowelStringsOfLength(0, n);
    }

    private int countDistinctSortedVowelStringsOfLength(int charIndex, int charsCapacity) {
        if (charsCapacity == 0) {
            return 1;
        }

        charsCapacity--;
        int result = 0;
        for (int i = charIndex; i < 5; i++) { // 5 is a number of all existing vowels
            result += countDistinctSortedVowelStringsOfLength(i, charsCapacity);
        }
        return result;
    }
}
