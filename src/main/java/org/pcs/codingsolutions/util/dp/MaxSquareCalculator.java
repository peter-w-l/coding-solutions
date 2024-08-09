package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 */
@UtilityClass
public class MaxSquareCalculator {
    public int getMaxSquare(char[][] matrix) {
        int matrixWidth = matrix.length;
        int matrixHeight = matrix[0].length;
        int[][] result = new int[matrixWidth][matrixHeight];
        int maxSquareSideLength = 0;
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixHeight; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') {
                        result[i][j] = 1;
                        maxSquareSideLength = Math.max(result[i][j], maxSquareSideLength);
                    }
                } else if (matrix[i][j] == '1') {
                    int min = result[i - 1][j - 1];
                    min = Math.min(result[i - 1][j], min);
                    min = Math.min(result[i][j - 1], min);
                    result[i][j] = min + 1;
                    maxSquareSideLength = Math.max(result[i][j], maxSquareSideLength);
                }
            }
        }

        return maxSquareSideLength * maxSquareSideLength;
    }
}
