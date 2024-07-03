package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b
 * where v = |a.val - b.val| and a is an ancestor of b.
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 */
@UtilityClass
public class BinaryTreeMaxDiffWithAncestorCalculator {

    public int getMaxDiffWithAncestor(TreeNode root) {
        return getMaxDiffWithAncestor(root, root.getVal(), root.getVal()); // Time complexity is O(N). Space complexity is O(1).
    }

    private int getMaxDiffWithAncestor(TreeNode treeNode, int minValueSoFar, int maxValueSoFar) {
        if (treeNode == null) {
            return 0;
        }

        int diffWithMinValue = Math.abs(treeNode.getVal() - minValueSoFar);
        int diffWithMaxValue = Math.abs(treeNode.getVal() - maxValueSoFar);
        int max = Math.max(diffWithMinValue, diffWithMaxValue);
        minValueSoFar = Math.min(minValueSoFar, treeNode.getVal());
        maxValueSoFar = Math.max(maxValueSoFar, treeNode.getVal());
        max = Math.max(max, getMaxDiffWithAncestor(treeNode.getLeft(), minValueSoFar, maxValueSoFar));
        max = Math.max(max, getMaxDiffWithAncestor(treeNode.getRight(), minValueSoFar, maxValueSoFar));
        return max;
    }
}
