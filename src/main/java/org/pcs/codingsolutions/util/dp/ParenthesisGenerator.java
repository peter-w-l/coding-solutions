package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
@UtilityClass
public class ParenthesisGenerator {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generate(n, n, new StringBuilder(), results);
        return results;
    }

    private void generate(int leftParenthesisNotUsedCount,
                          int rightParenthesisNotUsedCount,
                          StringBuilder resultBuilder,
                          List<String> results) {
        if (leftParenthesisNotUsedCount == 0 && rightParenthesisNotUsedCount == 0) {
            results.add(resultBuilder.toString());
        }

        if (leftParenthesisNotUsedCount != 0) {
            resultBuilder.append('(');
            generate(leftParenthesisNotUsedCount - 1, rightParenthesisNotUsedCount, resultBuilder, results);
            resultBuilder.deleteCharAt(resultBuilder.length() - 1);
        }

        if (rightParenthesisNotUsedCount > leftParenthesisNotUsedCount) {
            resultBuilder.append(')');
            generate(leftParenthesisNotUsedCount, rightParenthesisNotUsedCount - 1, resultBuilder, results);
            resultBuilder.deleteCharAt(resultBuilder.length() - 1);
        }
    }
}
