package org.pcs.codingsolutions.util.dp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for:
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions:
 * i.e. you may buy at most k times and sell at most k times.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * <p>
 * Solution explanation:
 * <a href="resources/188_max_stock_profit_calculator_diagram.png"> Diagram with solution explanation</a>
 */
@UtilityClass
public class MaxStockProfitCalculator {
    public int getMaxProfit(int numberOfTransactionsAllowed, int[] pricesPerDay) {
        int[][] currentDayCache = new int[4][numberOfTransactionsAllowed + 1];
        int[][] prevDayCache = new int[4][numberOfTransactionsAllowed + 1];
        Arrays.stream(prevDayCache)
                .forEach(thirdArray -> Arrays.fill(thirdArray, Integer.MIN_VALUE));

        // base cases
        prevDayCache[StockOperation.BUY.getValue()][numberOfTransactionsAllowed] = -pricesPerDay[0];
        prevDayCache[StockOperation.SKIP_AFTER_SELLING.getValue()][numberOfTransactionsAllowed] = 0;

        for (int dayIndex = 1; dayIndex < pricesPerDay.length; dayIndex++) {
            Arrays.stream(currentDayCache)
                    .forEach(thirdArray -> Arrays.fill(thirdArray, Integer.MIN_VALUE));
            for (StockOperation stockOperation : StockOperation.values()) {
                for (int numberOfPathTransactionsLeft = 0; numberOfPathTransactionsLeft <= numberOfTransactionsAllowed; numberOfPathTransactionsLeft++) {
                    if (prevDayCache[stockOperation.getValue()][numberOfPathTransactionsLeft] != Integer.MIN_VALUE) {
                        setMaxProfitToCache(dayIndex,
                                numberOfPathTransactionsLeft,
                                pricesPerDay,
                                stockOperation,
                                currentDayCache,
                                prevDayCache);
                    }
                }
            }
            int[][] temp = prevDayCache;
            prevDayCache = currentDayCache;
            currentDayCache = temp;
        }
        int[][] lastDayCache = prevDayCache;
        return IntStream.range(0, 4)
                .flatMap(operationIndex -> IntStream.rangeClosed(0, numberOfTransactionsAllowed)
                        .map(numberOfTransactionsLeft -> lastDayCache[operationIndex][numberOfTransactionsLeft]))
                .max()
                .orElse(0);
    }

    private void setMaxProfitToCache(int dayIndex,
                                     int numberOfTransactionsAllowed,
                                     int[] pricesPerDay,
                                     StockOperation previousStockOperation,
                                     int[][] dayCache,
                                     int[][] prevDayCache) {
        switch (previousStockOperation) {
            case BUY -> {
                int profitFromBuying = prevDayCache[StockOperation.BUY.getValue()][numberOfTransactionsAllowed];
                setMaxProfitFromSelling(profitFromBuying,
                        numberOfTransactionsAllowed,
                        pricesPerDay[dayIndex],
                        dayCache);

                dayCache[StockOperation.SKIP_AFTER_BUYING.getValue()][numberOfTransactionsAllowed] = Math.max(
                        profitFromBuying,
                        dayCache[StockOperation.SKIP_AFTER_BUYING.getValue()][numberOfTransactionsAllowed]);
            }
            case SELL -> {
                int profitFromSelling = prevDayCache[StockOperation.SELL.getValue()][numberOfTransactionsAllowed];

                setMaxProfitFromBuying(profitFromSelling,
                        numberOfTransactionsAllowed,
                        pricesPerDay[dayIndex],
                        dayCache);

                dayCache[StockOperation.SKIP_AFTER_SELLING.getValue()][numberOfTransactionsAllowed] = Math.max(
                        profitFromSelling,
                        dayCache[StockOperation.SKIP_AFTER_SELLING.getValue()][numberOfTransactionsAllowed]);
            }
            case SKIP_AFTER_BUYING, SKIP_AFTER_SELLING -> {
                int profitSoFar = prevDayCache[previousStockOperation.getValue()][numberOfTransactionsAllowed];

                if (previousStockOperation == StockOperation.SKIP_AFTER_BUYING) {
                    setMaxProfitFromSelling(profitSoFar,
                            numberOfTransactionsAllowed,
                            pricesPerDay[dayIndex],
                            dayCache);
                } else {
                    setMaxProfitFromBuying(profitSoFar,
                            numberOfTransactionsAllowed,
                            pricesPerDay[dayIndex],
                            dayCache);
                }

                dayCache[previousStockOperation.getValue()][numberOfTransactionsAllowed] = Math.max(
                        profitSoFar,
                        dayCache[previousStockOperation.getValue()][numberOfTransactionsAllowed]);
            }
        }
    }

    private void setMaxProfitFromBuying(int profitSoFar,
                                        int numberOfTransactionsAllowed,
                                        int stockPrice,
                                        int[][] dayCache) {
        if (numberOfTransactionsAllowed > 0) {
            dayCache[StockOperation.BUY.getValue()][numberOfTransactionsAllowed] = Math.max(
                    profitSoFar - stockPrice,
                    dayCache[StockOperation.BUY.getValue()][numberOfTransactionsAllowed]);
        }
    }

    private void setMaxProfitFromSelling(int profitSoFar,
                                         int numberOfTransactionsAllowed,
                                         int stockPrice,
                                         int[][] dayCache) {
        if (numberOfTransactionsAllowed > 0) {
            dayCache[StockOperation.SELL.getValue()][numberOfTransactionsAllowed - 1] = Math.max(
                    profitSoFar + stockPrice,
                    dayCache[StockOperation.SELL.getValue()][numberOfTransactionsAllowed - 1]);
        }
    }

    @Getter
    @AllArgsConstructor
    private enum StockOperation {
        BUY(0),
        SELL(1),
        SKIP_AFTER_BUYING(2),
        SKIP_AFTER_SELLING(3);

        private final int value;
    }
}
