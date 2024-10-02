package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * Solution for:
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 * <p>
 * Note:
 * <p>
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 */
@UtilityClass
public class MaxStockProfitWithFeeCalculator {
    public int getMaxProfit(int[] pricesPerDay, int transactionFee) {
        int[][] cache = new int[pricesPerDay.length][2];
        Arrays.stream(cache).forEach(innerArray -> Arrays.fill(innerArray, Integer.MIN_VALUE));

        // base cases
        cache[0][1] = -pricesPerDay[0];
        cache[0][0] = 0;
        for (int dayIndex = 1; dayIndex < pricesPerDay.length; dayIndex++) {
            Arrays.fill(cache[dayIndex], Integer.MIN_VALUE);
            for (int stockHoldingIndex = 0; stockHoldingIndex <= 1; stockHoldingIndex++) {
                if (cache[dayIndex - 1][stockHoldingIndex] != Integer.MIN_VALUE) {
                    if (stockHoldingIndex == 0) {
                        cache[dayIndex][1] = Math.max(
                                cache[dayIndex - 1][stockHoldingIndex] - pricesPerDay[dayIndex],
                                cache[dayIndex][1]);
                        cache[dayIndex][stockHoldingIndex] = Math.max(
                                cache[dayIndex - 1][stockHoldingIndex],
                                cache[dayIndex][stockHoldingIndex]);
                    } else {
                        cache[dayIndex][0] = Math.max(
                                cache[dayIndex - 1][stockHoldingIndex]  + pricesPerDay[dayIndex] - transactionFee,
                                cache[dayIndex][0]);
                        cache[dayIndex][1] = Math.max(
                                cache[dayIndex - 1][stockHoldingIndex],
                                cache[dayIndex][1]);
                    }
                }
            }

        }
        return Math.max(cache[pricesPerDay.length - 1][0], cache[pricesPerDay.length - 1][1]);
    }
}
