package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST
 * such that their sum is equal to k, or false otherwise.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -104 <= Node.val <= 104
 * root is guaranteed to be a valid binary search tree.
 * -105 <= k <= 105
 */
@UtilityClass
public class BinarySearchTreeSumCalculator {
    public boolean areNodesWithSumExist(TreeNode root, int targetSum) {
        return areNodesWithSumExist(root, root, targetSum);
    }

    private boolean areNodesWithSumExist(TreeNode root, TreeNode currentNode, int targetSum) {
        if (currentNode == null) {
            return false;
        }

        int complement = targetSum - currentNode.getVal();

        return (currentNode.getVal() != complement && isNodeWithValueExists(root, complement))
                || areNodesWithSumExist(root, currentNode.getLeft(), targetSum)
                || areNodesWithSumExist(root, currentNode.getRight(), targetSum);
    }

    private boolean isNodeWithValueExists(TreeNode treeNode, int value) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.getVal() == value) {
            return true;
        } else if (treeNode.getVal() > value) {
            return isNodeWithValueExists(treeNode.getLeft(), value);
        }
        return isNodeWithValueExists(treeNode.getRight(), value);
    }
}
