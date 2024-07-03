package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for:
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
@UtilityClass
public class BinaryTreeRightSideCalculator {
    public List<Integer> getMostRightNodesValues(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();
        addMostRightNodesValues(root, result, 0);

        return result;
    }

    private void addMostRightNodesValues(TreeNode treeNode, List<Integer> result, int level) {
        if (treeNode == null) {
            return;
        }
        if (result.size() == level) {
            result.add(treeNode.getVal());
        }
        addMostRightNodesValues(treeNode.getRight(), result, level + 1);
        addMostRightNodesValues(treeNode.getLeft(), result, level + 1);
    }
}
