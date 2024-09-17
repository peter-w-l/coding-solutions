package org.pcs.codingsolutions.util.slidingwindow;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a  subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
@UtilityClass
public class MinSizeSubarraySumCalculator {
    public int getMinSubArrayLen(int target, int[] nums) {
        int minNumberOfNums = Integer.MAX_VALUE;
        int beginIndex = 0;
        int endIndex = beginIndex;
        int sum = nums[beginIndex];

        while (beginIndex < nums.length && endIndex < nums.length) {
            if (sum < target) {
                endIndex++;
                if (endIndex < nums.length) {
                    sum += nums[endIndex];
                }
            } else {
                while (sum >= target) {
                    minNumberOfNums = Math.min(endIndex - beginIndex + 1, minNumberOfNums);
                    sum -= nums[beginIndex];
                    beginIndex++;
                }
            }
        }
        return minNumberOfNums == Integer.MAX_VALUE ? 0 : minNumberOfNums;
    }
}
