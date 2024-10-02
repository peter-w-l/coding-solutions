package org.pcs.codingsolutions.util.dp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * Solution for:
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
@UtilityClass
public class MaxStockProfitWithCooldownCalculator {
    public int getMaxProfit(int[] pricesPerDay) {
        int[][] cache = new int[pricesPerDay.length][State.values().length];
        Arrays.stream(cache).forEach(innerArray -> Arrays.fill(innerArray, Integer.MIN_VALUE));

        // base cases
        cache[0][State.HOLDING_STOCK.getValue()] = -pricesPerDay[0];
        cache[0][State.NONE.getValue()] = 0;

        for (int dayIndex = 1; dayIndex < pricesPerDay.length; dayIndex++) {
            for (var state : State.values()) {
                if (cache[dayIndex - 1][state.getValue()] != Integer.MIN_VALUE) {
                    int prevProfit = cache[dayIndex - 1][state.getValue()];
                    switch (state) {
                        case NONE -> {
                            cache[dayIndex][State.NONE.getValue()] = Math.max(
                                    cache[dayIndex][State.NONE.getValue()],
                                    prevProfit);
                            cache[dayIndex][State.HOLDING_STOCK.getValue()] = Math.max(
                                    cache[dayIndex][State.HOLDING_STOCK.getValue()],
                                    prevProfit - pricesPerDay[dayIndex]);
                        }
                        case HOLDING_STOCK -> {
                            cache[dayIndex][state.getValue()] = Math.max(cache[dayIndex][state.getValue()], prevProfit);
                            cache[dayIndex][State.COOLDOWN.getValue()] = Math.max(
                                    cache[dayIndex][State.COOLDOWN.getValue()],
                                    prevProfit + pricesPerDay[dayIndex]);
                        }
                        case COOLDOWN -> cache[dayIndex][State.NONE.getValue()] = Math.max(
                                cache[dayIndex][State.NONE.getValue()],
                                prevProfit);

                    }
                }
            }
        }
        return Arrays.stream(cache[pricesPerDay.length - 1]).max().orElse(0);
    }

    @Getter
    @AllArgsConstructor
    private enum State {
        NONE(0),
        HOLDING_STOCK(1),
        COOLDOWN(2);

        private final int value;
    }
}
