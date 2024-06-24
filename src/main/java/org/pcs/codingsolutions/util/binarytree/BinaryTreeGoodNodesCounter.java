package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreeGoodNodesCounter {
    public static int countGoodNodes(TreeNode root) {
        return countGoodNodes(root, root.getVal());
    }

    private static int countGoodNodes(TreeNode node, int maxValueInPath) {
        int count = 0;
        if (node == null) {
            return count;
        }
        if (isGoodNode(node, maxValueInPath)) {
            count++;
            maxValueInPath = Math.max(node.getVal(), maxValueInPath);
        }
        count += countGoodNodes(node.getLeft(), maxValueInPath);
        count += countGoodNodes(node.getRight(), maxValueInPath);

        return count;
    }

    private static boolean isGoodNode(TreeNode node, int maxValueInPath) {
        return Math.max(node.getVal(), maxValueInPath) == node.getVal();
    }
}
