package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for:
 * <p>
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element in the next row that is
 * either directly below or diagonally left/right. Specifically, the next element from position (row, col)
 * will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * <p>
 * Constraints:
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
@UtilityClass
public class GridFallingPathCalculator {
    public int getMinFallingPathSum(int[][] matrix) {
        int matrixLength = matrix.length;
        int[][] cache = new int[matrixLength][matrixLength];

        // base cases
        IntStream.range(0, matrixLength)
                .forEach(columnIndex -> cache[0][columnIndex] = matrix[0][columnIndex]);

        for (int rowIndex = 1; rowIndex < matrixLength; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
                int parentPathMinSum = cache[rowIndex - 1][columnIndex];

                if (columnIndex > 0) {
                    parentPathMinSum = Math.min(cache[rowIndex - 1][columnIndex - 1], parentPathMinSum);
                }
                if (columnIndex < matrixLength - 1) {
                    parentPathMinSum = Math.min(cache[rowIndex - 1][columnIndex + 1], parentPathMinSum);
                }
                cache[rowIndex][columnIndex] = parentPathMinSum + matrix[rowIndex][columnIndex];
            }
        }

        return Arrays.stream(cache[matrixLength - 1])
                .min()
                .orElse(Integer.MAX_VALUE);
    }
}
