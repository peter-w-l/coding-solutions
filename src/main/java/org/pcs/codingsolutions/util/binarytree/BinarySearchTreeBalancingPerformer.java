package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 * If there is more than one answer, return any of them.
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 105
 */
@UtilityClass
public class BinarySearchTreeBalancingPerformer {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> treeValues = new ArrayList<>();
        extractValuesOrdered(root, treeValues);

        return buildBST(treeValues, 0, treeValues.size() - 1); // Time complexity is O(N). Space complexity is O(N).
    }

    private TreeNode buildBST(List<Integer> treeValues, int beginIndexInclusive, int endIndexInclusive) {
        if (beginIndexInclusive > endIndexInclusive) {
            return null;
        }

        int middleNodeIndex = (endIndexInclusive + beginIndexInclusive) / 2; // begin + ((end - begin) / 2) = (end + begin) / 2

        TreeNode root = new TreeNode(treeValues.get(middleNodeIndex), null, null);
        root.setLeft(buildBST(treeValues, beginIndexInclusive, middleNodeIndex - 1));
        root.setRight(buildBST(treeValues, middleNodeIndex + 1, endIndexInclusive));

        return root;
    }

    private void extractValuesOrdered(TreeNode treeNode, List<Integer> result) { // inorder traversal on BST guarantees an ordered result
        if (treeNode == null) {
            return;
        }

        extractValuesOrdered(treeNode.getLeft(), result);
        result.add(treeNode.getVal());
        extractValuesOrdered(treeNode.getRight(), result);
    }
}
