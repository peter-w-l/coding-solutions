package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
@UtilityClass
public class MaxProfitCalculator {
    public int getMaxProfit(int[] prices) {
        int maxProfit = 0;
        int priceToBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < priceToBuy) {
                priceToBuy = prices[i];
            } else if (prices[i] - priceToBuy > maxProfit) {
                maxProfit = prices[i] - priceToBuy;
            }
        }

        return maxProfit;
    }

}
