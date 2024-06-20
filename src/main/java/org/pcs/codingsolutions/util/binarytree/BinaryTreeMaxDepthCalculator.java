package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreeMaxDepthCalculator {
    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLeafMaxDepth = getMaxDepth(root.getLeft());
        int rightLeafMaxDepth = getMaxDepth(root.getRight());
        return Math.max(leftLeafMaxDepth, rightLeafMaxDepth) + 1;
    }
}
