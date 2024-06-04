package org.pcs.codingsolutions.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LongestSubarrayAfterDeletingCalculator {

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
