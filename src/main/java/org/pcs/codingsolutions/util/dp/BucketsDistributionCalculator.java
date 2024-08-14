package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * Solution for:
 * <p>
 * You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag.
 * You are also given an integer k that denotes the number of children to distribute all the bags of cookies to.
 * All the cookies in the same bag must go to the same child and cannot be split up.
 * The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
 * Return the minimum unfairness of all distributions.
 * <p>
 * Constraints:
 * <p>
 * 2 <= cookies.length <= 8
 * 1 <= cookies[i] <= 105
 * 2 <= k <= cookies.length
 */
@UtilityClass
public class BucketsDistributionCalculator {
    public int distributeAndGetMinUnfairness(int[] items, int bucketsNumber) {
        int[] buckets = new int[bucketsNumber];
        int[] result = new int[]{Integer.MAX_VALUE};
        backtrack(items, buckets, 0, result);
        return result[0];
    }

    private void backtrack(int[] items,
                           int[] buckets,
                           int itemId,
                           int[] result) {
        if (itemId == items.length) { // every item is distributed
            result[0] = Math.min(getUnfairness(buckets), result[0]);
            return;
        }
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] += items[itemId];
            backtrack(items, buckets, itemId + 1, result);
            buckets[i] -= items[itemId];
        }
    }

    private int getUnfairness(int[] buckets) {
        return Arrays.stream(buckets).max().orElse(0);
    }
}
