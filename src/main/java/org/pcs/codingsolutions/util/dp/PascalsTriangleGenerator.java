package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above.
 * <p>
 * Constraints:
 * <p>
 * 1 <= numRows <= 30
 */
@UtilityClass
public class PascalsTriangleGenerator {
    public List<Integer> generateRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        } else if (rowIndex == 1) {
            return List.of(1, 1);
        }
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int prev = 1;
            for (int j = 1; j < rowIndex; j++) {
                int temp = row[j];
                row[j] = prev + row[j];
                prev = temp;
            }
            row[rowIndex] = 1;
        }
        return Arrays.stream(row).boxed().toList();
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleRows = new ArrayList<>();
        List<Integer> row = List.of(1);
        triangleRows.add(row);
        for (int i = 0; i < numRows - 1; i++) {
            row = generateNextRow(row);
            triangleRows.add(row);
        }
        return triangleRows;
    }

    private List<Integer> generateNextRow(List<Integer> row) {
        List<Integer> nextRow = new ArrayList<>();
        nextRow.add(1);
        int rowSize = row.size();
        for (int i = 0; i < rowSize - 1; i++) {
            nextRow.add(row.get(i) + row.get(i + 1));
        }
        nextRow.add(1);
        return nextRow;
    }
}
