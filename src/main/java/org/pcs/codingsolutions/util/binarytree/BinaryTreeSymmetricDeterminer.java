package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 */
@UtilityClass
public class BinaryTreeSymmetricDeterminer {
    public boolean isSymmetric(TreeNode root) {
        return isMirrored(root.getLeft(), root.getRight());
    }

    public boolean isMirrored(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null || rightTree == null) {
            return leftTree == null && rightTree == null;
        }

        return leftTree.getVal() == rightTree.getVal()
                && isMirrored(leftTree.getLeft(), rightTree.getRight())
                && isMirrored(leftTree.getRight(), rightTree.getLeft());
    }
}
