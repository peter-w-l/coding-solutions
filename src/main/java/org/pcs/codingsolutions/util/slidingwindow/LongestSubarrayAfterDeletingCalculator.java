package org.pcs.codingsolutions.util.slidingwindow;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Solution for:
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestSubarrayAfterDeletingCalculator {

    public static int getLongestSubarrayAfterDeletingOne(int[] nums) {
        int numsLength = nums.length;
        int maxOnes = 0;
        int zeroesLimit = 1;
        int zeroes = 0;
        int leftIndex = 0;
        for (int rightIndex = 0; rightIndex < numsLength; rightIndex++) {
            if (nums[rightIndex] == 0) {
                zeroes++;
            }
            while (zeroes > zeroesLimit) {
                if (nums[leftIndex] == 0) {
                    zeroes --;
                }
                leftIndex ++;
            }

            maxOnes = Math.max(maxOnes, rightIndex - leftIndex);
        }
        return maxOnes; // time complexity is O(N). Space complexity is O(1).
    }
}
