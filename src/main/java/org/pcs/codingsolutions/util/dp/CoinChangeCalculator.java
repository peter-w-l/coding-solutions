package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * Solution for:
 * <p>
 * You are given an integer array coins representing coins of different denominations and
 * an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up
 * by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
@UtilityClass
public class CoinChangeCalculator {
    public int getMinNumOfCoinsForAmount(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        // Initialize dp array with a large value to signify impossible states
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // It takes 0 coins to make the amount 0

        for(int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

