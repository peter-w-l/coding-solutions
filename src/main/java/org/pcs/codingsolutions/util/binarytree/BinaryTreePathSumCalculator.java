package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreePathSumCalculator {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private static boolean hasPathSum(TreeNode treeNode, int targetSum, int sumSoFar) {
        if (treeNode == null) {
            return false;
        }

        int sumWithCurrentNode = sumSoFar + treeNode.getVal();

        if (treeNode.getLeft() == null && treeNode.getRight() == null) { // leaf
            return sumWithCurrentNode == targetSum;
        }

        return hasPathSum(treeNode.getRight(), targetSum, sumWithCurrentNode)
                || hasPathSum(treeNode.getLeft(), targetSum, sumWithCurrentNode);
    }
}
