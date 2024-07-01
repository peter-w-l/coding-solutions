package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 */
@UtilityClass
public class BinarySearchTreeSearchPerformer {
    public TreeNode searchBSTNodeWithValue(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.getVal() == val) {
            return root;
        } else if (root.getVal() < val) {
            return searchBSTNodeWithValue(root.getRight(), val);
        } else {
            return searchBSTNodeWithValue(root.getLeft(), val);
        }
    }
}
