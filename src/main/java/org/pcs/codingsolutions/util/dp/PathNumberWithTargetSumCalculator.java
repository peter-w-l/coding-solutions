package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for:
 * <p>
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums
 * and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build
 * the expression "+2-1". Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
@UtilityClass
public class PathNumberWithTargetSumCalculator {
    public int getPathNumberWithTargetSum(int[] numbers, int targetSum) {
        var cache = new HashMap<String, Integer>();
        return getPathNumberWithTargetSum(numbers.length - 1,
                0,
                numbers,
                targetSum,
                cache);
    }

    private int getPathNumberWithTargetSum(int numberIndex,
                                           int sumSoFar,
                                           int[] numbers,
                                           int targetSum,
                                           Map<String, Integer> cache) {
        if (numberIndex == 0) {
            int result = 0;
            if (targetSum == sumSoFar + numbers[0]) {
                result++;
            }
            if (targetSum == sumSoFar - numbers[0]) {
                result++;
            }
            return result;
        }

        int sumSoFarAfterAdding = sumSoFar + numbers[numberIndex];
        var cacheKeyAdding = numberIndex + "," + sumSoFarAfterAdding;
        if (!cache.containsKey(cacheKeyAdding)) {
            int numberOfPaths = getPathNumberWithTargetSum(numberIndex - 1,
                    sumSoFarAfterAdding,
                    numbers,
                    targetSum,
                    cache);
            cache.put(cacheKeyAdding, numberOfPaths);
        }
        int sumSoFarAfterSubtracting = sumSoFar - numbers[numberIndex];
        var cacheKeySubtracting = numberIndex + "," + sumSoFarAfterSubtracting;
        if (!cache.containsKey(cacheKeySubtracting)) {
            int numberOfPaths = getPathNumberWithTargetSum(numberIndex - 1,
                    sumSoFarAfterSubtracting,
                    numbers,
                    targetSum,
                    cache);
            cache.put(cacheKeySubtracting, numberOfPaths);
        }

        return cache.get(cacheKeyAdding) + cache.get(cacheKeySubtracting);
    }
}
