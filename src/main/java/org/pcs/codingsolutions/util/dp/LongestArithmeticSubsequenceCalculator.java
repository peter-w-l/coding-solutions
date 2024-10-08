package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Solution for:
 * <p>
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 * Note that:
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 */
@UtilityClass
public class LongestArithmeticSubsequenceCalculator {
    public int getLongestArithmeticSubSequenceLength(int[] numbers) {
        var differences = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                differences.add(numbers[j] - numbers[i]);
            }
        }

        var cache = new HashMap<Integer, Integer>();
        int longestArithmeticSubSequenceLength = 1;
        for (int difference : differences) {
            cache.clear();
            for (int number : numbers) {
                int longestForNumberAndDiff = 1;
                if (cache.containsKey(number - difference)) {
                    longestForNumberAndDiff = cache.get(number - difference) + 1;
                    longestArithmeticSubSequenceLength = Math.max(
                            longestForNumberAndDiff,
                            longestArithmeticSubSequenceLength);
                }
                cache.put(number, longestForNumberAndDiff);
            }
        }

        return longestArithmeticSubSequenceLength;
    }
}
