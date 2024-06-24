package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreeMinDepthCalculator {
    public static int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeft() == null) {
            return getMinDepth(root.getRight()) + 1;
        }
        if (root.getRight() == null) {
            return getMinDepth(root.getLeft()) + 1;
        }
        return Math.min(getMinDepth(root.getLeft()), getMinDepth(root.getRight())) + 1;
    }

}
