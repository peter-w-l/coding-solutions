package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
 * you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * Constraints:
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
@UtilityClass
public class MinPathCostCalculator {

    public int getMinPathCost(int[] stepCost) {
        int[] pathCost = new int[stepCost.length];
        pathCost[0] = stepCost[0];
        pathCost[1] = stepCost[1];

        for (int i = 2; i < stepCost.length; i++) {
            pathCost[i] = stepCost[i] + Math.min(pathCost[i - 1], pathCost[i - 2]);
        }

        return Math.min(pathCost[stepCost.length - 1], pathCost[stepCost.length - 2]);
    }

}
