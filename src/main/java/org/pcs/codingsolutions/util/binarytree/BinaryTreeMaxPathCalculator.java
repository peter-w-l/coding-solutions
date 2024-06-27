package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */
@UtilityClass
public class BinaryTreeMaxPathCalculator {
    public int getMaxNumberOfEdges(TreeNode root) {
        int[] max = new int[]{0};
        getMaxNumberOfEdges(root, max);
        return max[0];
    }

    private int getMaxNumberOfEdges(TreeNode treeNode, int[] max) { // in-order traversal
        if (treeNode == null) {
            return 0;
        }

        int leftMax = getMaxNumberOfEdges(treeNode.getLeft(), max);
        int rightMax = getMaxNumberOfEdges(treeNode.getRight(), max);
        int sum = leftMax + rightMax;
        max[0] = Math.max(max[0], sum);

        return Math.max(leftMax, rightMax) + 1;
    }
}
