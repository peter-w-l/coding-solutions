package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.function.UnaryOperator;

/**
 * Solution for:
 * <p>
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive
 * at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5 * 10^4].
 * 0 <= Node.val <= 5 * 10^4
 * The tree is guaranteed to be complete.
 */
@UtilityClass
public class BinaryTreeCompleteNodesCalculator {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root, TreeNode::getLeft);
        int rightHeight = getHeight(root, TreeNode::getRight);
        if (leftHeight == rightHeight) {
            return countNodesWithConstantTreeHeight(leftHeight);
        }

        return countNodes(root.getLeft()) + countNodes(root.getRight()) + 1;
    }

    private int countNodesWithConstantTreeHeight(int height) {
        int numberOfNodes = 0;
        for (int i = 0; i < height; i ++) {
            numberOfNodes += pow(2, i );
        }

        return numberOfNodes;
    }

    private int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        return a * pow(a, b -1);
    }

    private int getHeight(TreeNode treeNode, UnaryOperator<TreeNode> treeNodeExtractor) {
        if (treeNode == null) {
            return 0;
        }
        return getHeight(treeNodeExtractor.apply(treeNode), treeNodeExtractor) + 1;
    }
}
