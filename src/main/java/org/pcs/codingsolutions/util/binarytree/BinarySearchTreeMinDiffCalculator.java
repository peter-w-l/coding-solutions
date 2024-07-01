package org.pcs.codingsolutions.util.binarytree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values
 * of any two different nodes in the tree.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 */
@UtilityClass
public class BinarySearchTreeMinDiffCalculator {
    public int getMinimumDifference(TreeNode root) {
        return getMinDifference(root, new TreeNodeValue());
    }

    private int getMinDifference(TreeNode treeNode, TreeNodeValue prevNode) {
        if (treeNode == null) {
            return Integer.MAX_VALUE;
        }
        int min = getMinDifference(treeNode.getLeft(), prevNode);
        if (prevNode.getValue() != null) {
            min = Math.min(min, Math.abs(treeNode.getVal() - prevNode.getValue()));
        }
        prevNode.setValue(treeNode.getVal());

        min = Math.min(min, getMinDifference(treeNode.getRight(), prevNode));
        return min;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    private static class TreeNodeValue {
        private Integer value;
    }
}
