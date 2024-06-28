package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 * <p>
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and
 * all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values
 * is treated as 0. The rule is similar if the node does not have a right child.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
@UtilityClass
public class BinaryTreeTiltCalculator {
    public int getTiltSum(TreeNode root) {
        int[] tiltSum = new int[]{0};
        getTreeNodesSumAndUpdateTiltSum(root, tiltSum);

        return tiltSum[0];
    }

    private int getTreeNodesSumAndUpdateTiltSum(TreeNode treeNode, int[] tiltSumSoFar) {
        if (treeNode == null) {
            return 0;
        }

        int leftTreeSum = getTreeNodesSumAndUpdateTiltSum(treeNode.getLeft(), tiltSumSoFar);
        int rightTreeSum = getTreeNodesSumAndUpdateTiltSum(treeNode.getRight(), tiltSumSoFar);
        tiltSumSoFar[0] = tiltSumSoFar[0] + Math.abs(leftTreeSum - rightTreeSum);
        return leftTreeSum + rightTreeSum + treeNode.getVal();
    }
}
