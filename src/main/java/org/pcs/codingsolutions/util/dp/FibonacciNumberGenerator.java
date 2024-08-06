package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 30
 */
@UtilityClass
public class FibonacciNumberGenerator {
    public int generate(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int result;
        int prevPrev = 0;
        int prev = 1;
        for (int i = 2; i <= n; i ++) {
            result = prev + prevPrev;
            prevPrev = prev;
            prev = result;
        }
        return prev;
    }
}
