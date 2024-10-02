package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner
 * (i.e., grid[0][0]). The robot tries to move to the bottom-right corner(i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include
 * any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 * <p>
 * Constraints:
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
@UtilityClass
public class GridPathCalculator {
    public int getUniquePathNumber(int[][] obstacleGrid) {
        int rowsNumber = obstacleGrid.length;
        int columnsNumber = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] cache = new int[rowsNumber][columnsNumber];

        // base case
        cache[0][0] = 1;

        for (int rowIndex = 0; rowIndex < rowsNumber; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnsNumber; columnIndex++) {
                if (obstacleGrid[rowIndex][columnIndex] == 1) {
                    continue;
                }
                if (rowIndex != 0) {
                    cache[rowIndex][columnIndex] += cache[rowIndex - 1][columnIndex];
                }
                if (columnIndex != 0) {
                    cache[rowIndex][columnIndex] += cache[rowIndex][columnIndex - 1];
                }
            }
        }

        return cache[rowsNumber - 1][columnsNumber - 1];
    }
}
