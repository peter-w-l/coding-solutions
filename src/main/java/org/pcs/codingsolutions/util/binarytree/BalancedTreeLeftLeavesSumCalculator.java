package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, return the sum of all left leaves.
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */
@UtilityClass
public class BalancedTreeLeftLeavesSumCalculator {
    public int sumLeftLeaves(TreeNode root) {
        return sumLeftLeaves(root.getLeft(), true) + sumLeftLeaves(root.getRight(), false);
    }

    public int sumLeftLeaves(TreeNode treeNode, boolean isLeft) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.getLeft() == null && treeNode.getRight() == null && isLeft) { // left leaf
            return treeNode.getVal();
        }
        int leftNodeLeftLeavesSum = sumLeftLeaves(treeNode.getLeft(), true);
        int rightNodeLeftLeavesSum = sumLeftLeaves(treeNode.getRight(), false);
        return leftNodeLeftLeavesSum + rightNodeLeftLeavesSum;
    }
}
