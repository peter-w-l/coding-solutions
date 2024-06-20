package org.pcs.codingsolutions.util.twopointers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * Solution for:
 * <p>
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxNumberOfPairsCalculator {

    /**
     * Returns the maximum number of pairs with a specified sum
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int getMaxNumberOfPairsWithSum(int[] nums, int pairSum) {
        var map = new HashMap<Integer, Integer>();
        int numOfPairs = 0;

        for (int num : nums) {
            Integer substractionValue = pairSum - num;
            if (substractionValue < 0) {
                continue;
            }
            if (map.containsKey(substractionValue)) {
                numOfPairs++;
                var count = map.get(substractionValue);
                count--;
                if (count == 0) {
                    map.remove(substractionValue);
                } else {
                    map.put(substractionValue, count);
                }
            } else {
                map.merge(num, 1, Integer::sum);
            }
        }
        return numOfPairs;
    }
}
