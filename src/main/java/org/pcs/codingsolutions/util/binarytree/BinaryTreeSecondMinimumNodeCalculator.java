package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree
 * has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value
 * among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Constraints:
 * <ul>
 *     <li>The number of nodes in the tree is in the range [1, 25].</li>
 *     <li>1 <= Node.val <= 231 - 1</li>
 *     <li>root.val == min(root.left.val, root.right.val) for each internal node of the tree.</li>
 * </ul>
 */
@UtilityClass
public class BinaryTreeSecondMinimumNodeCalculator {
    public int getSecondMinimumValue(TreeNode root) {
        int minValue = getSmallestValue(root, -1);
        return getSmallestValue(root, minValue); // Time complexity is O(2N) = O(N). Space complexity is O(1).
    }

    private int getSmallestValue(TreeNode treeNode, int exception) {
        if (treeNode == null) {
            return -1;
        }

        int min = treeNode.getVal() == exception ? -1 : treeNode.getVal();
        min = getMin(min, getSmallestValue(treeNode.getLeft(), exception));
        return getMin(min, getSmallestValue(treeNode.getRight(), exception));
    }

    private int getMin(int left, int right) {
        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }
}
