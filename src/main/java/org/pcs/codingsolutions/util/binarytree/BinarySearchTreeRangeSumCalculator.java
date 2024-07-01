package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes
 * with a value in the inclusive range [low, high].
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */
@UtilityClass
public class BinarySearchTreeRangeSumCalculator {
    public int getBSTRangeSum(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.getVal() >= low && root.getVal() <= high) {
            return root.getVal() + getBSTRangeSum(root.getLeft(), low, high) + getBSTRangeSum(root.getRight(), low, high);
        } else if (root.getVal() > high) {
            return getBSTRangeSum(root.getLeft(), low, high);
        } else {
            return getBSTRangeSum(root.getRight(), low, high);
        }
    }
}
