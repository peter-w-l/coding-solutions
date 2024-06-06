package org.pcs.codingsolutions.util.hashmapset;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for:
 * <p>
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * <p>
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EqualRowAndColumnPairsCalculator {
    public static int areEqualPairs(int[][] grid) {
        int gridLength = grid.length;
        int pairsNum = 0;
        Map<List<Integer>, Integer> columnToCount = new HashMap<>();
        for (int columnIndex = 0; columnIndex < gridLength; columnIndex++) {
            List<Integer> column = new ArrayList<>();
            for (int rowIndex = 0; rowIndex < gridLength; rowIndex++) {
                column.add(grid[rowIndex][columnIndex]);
            }
            columnToCount.put(column, columnToCount.getOrDefault(column, 0) + 1);
        }

        for (int rowIndex = 0; rowIndex < gridLength; rowIndex++) {
            List<Integer> row = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < gridLength; columnIndex++) {
                row.add(grid[rowIndex][columnIndex]);
            }
            if (columnToCount.containsKey(row)) {
                pairsNum += columnToCount.get(row);
            }
        }
        return pairsNum; // time complexity is O(n^2). Space complexity is O(n^2)
    }
}
