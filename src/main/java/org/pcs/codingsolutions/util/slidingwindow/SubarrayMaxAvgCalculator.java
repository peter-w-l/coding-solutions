package org.pcs.codingsolutions.util.slidingwindow;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Solution for:
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SubarrayMaxAvgCalculator {
    public static double findMaxAvgInSubarraysWithLength(int[] nums, int subarrayLength) {
        int sum = 0;
        for (int i = 0; i < subarrayLength; i ++) {
            sum +=nums[i];
        }

        int maxSum = sum;

        int startIndex = 1;
        for (int endIndex = subarrayLength; endIndex < nums.length; endIndex ++) {
            sum = sum - nums[startIndex - 1] + nums[endIndex];
            maxSum = Math.max(maxSum, sum);
            startIndex++;
        }
        return (double)maxSum / subarrayLength; // time complexity is O(n). Space: O(1);
    }
}
