package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
 * return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [2, 100].
 * 1 <= Node.val <= 100
 * Each node has a unique value.
 * x != y
 * x and y are exist in the tree.
 */
@UtilityClass
public class BinaryTreeCousinNodesDeterminer {
    public boolean areCousinNodes(TreeNode root, int node1Value, int node2Value) {
        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        while (!nodes.isEmpty()) {
            boolean isValue1Found = false;
            boolean isValue2Found = false;
            int nodesInLevel = nodes.size();
            for (int i = 0; i < nodesInLevel; i++) {
                TreeNode currentNode = nodes.poll();

                if (hasAllChlidNodesWithValues(currentNode, node1Value, node2Value)) {
                    return false;
                }

                if (currentNode.getVal() == node1Value) {
                    isValue1Found = true;
                } else if (currentNode.getVal() == node2Value) {
                    isValue2Found = true;
                }

                if (isValue1Found && isValue2Found) {
                    return true;
                }
                if (currentNode.getLeft() != null) {
                    nodes.offer(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    nodes.offer(currentNode.getRight());
                }
            }
        }
        return false;
    }

    private boolean hasAllChlidNodesWithValues(TreeNode treeNode, int value1, int value2) {
        TreeNode leftNode = treeNode.getLeft();
        TreeNode rightNode = treeNode.getRight();
        return leftNode != null && rightNode != null
                && ((leftNode.getVal() == value1 && rightNode.getVal() == value2)
                || (leftNode.getVal() == value2 && rightNode.getVal() == value1));
    }
}
