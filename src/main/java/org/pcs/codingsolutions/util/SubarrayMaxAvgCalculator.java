package org.pcs.codingsolutions.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
