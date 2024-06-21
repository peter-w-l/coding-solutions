package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given a binary tree, determine if it is height-balanced. A height-balanced binary tree is a binary tree in which
 * the depth of the two subtrees of every node never differs by more than one.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BalancedBinaryTreeDeterminer {
    public static boolean isBalanced(TreeNode root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return true;
        }
        return Math.abs(countMaxDepth(root.getLeft()) - countMaxDepth(root.getRight())) <= 1
                && isBalanced(root.getLeft())
                && isBalanced(root.getRight());
    }

    private static int countMaxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return Math.max(countMaxDepth(treeNode.getLeft()), countMaxDepth(treeNode.getRight())) + 1;
    }
}
