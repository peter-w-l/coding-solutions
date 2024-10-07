package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.HashMap;

/**
 * Solution for:
 * <p>
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr
 * which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 * A subsequence is a sequence that can be derived from arr by deleting some or no elements
 * without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 */
@UtilityClass
public class LongestSubsequenceWithDiffCalculator {
    public int getLongestSubsequenceWithDiff(int[] numbers, int difference) {
        var cache = new HashMap<Integer, Integer>();
        for (int number : numbers) {
            cache.put(number + difference, cache.containsKey(number) ? cache.get(number) + 1 : 1);
        }

        return cache.values().stream()
                .max(Integer::compareTo)
                .orElse(1);
    }
}
