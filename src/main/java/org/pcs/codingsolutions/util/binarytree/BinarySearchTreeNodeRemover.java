package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -105 <= Node.val <= 105
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -105 <= key <= 105
 */
@UtilityClass
public class BinarySearchTreeNodeRemover {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.getVal()) {
            return removeRoot(root);
        }
        TreeNode target = getTreeNodeWithValue(root, key);
        if (target == null) {
            return root;
        }

        TreeNode parent = getParentTreeNode(root, target);
        if (parent.getLeft() != null && parent.getLeft().getVal() == target.getVal()) { // left child of a parent
            if (target.getRight() != null) {
                TreeNode node = getMostLeftChildNode(target.getRight());
                node.setLeft(target.getLeft());
                parent.setLeft(target.getRight());
            } else {
                parent.setLeft(target.getLeft());
            }
        } else {  // right child of a parent
            if (target.getRight() != null) {
                TreeNode node = getMostLeftChildNode(target.getRight());
                node.setLeft(target.getLeft());
                parent.setRight(target.getRight());
            } else {
                parent.setRight(target.getLeft());
            }
        }

        return root; // Time complexity is O(3H) = O(H). Space complexity is O(1).
    }

    private TreeNode removeRoot(TreeNode root) {
        if (root.getRight() != null) {
            TreeNode node = getMostLeftChildNode(root.getRight());
            node.setLeft(root.getLeft());
            return root.getRight();
        } else {
            return root.getLeft();
        }
    }

    private TreeNode getMostLeftChildNode(TreeNode current) {

        if (current.getLeft() == null) {
            return current;
        }
        return getMostLeftChildNode(current.getLeft());
    }

    private TreeNode getParentTreeNode(TreeNode current, TreeNode child) {
        if (current == null) {
            return null;
        }

        if (current.getLeft() != null) {
            if (current.getLeft().getVal() == child.getVal()) {
                return current;
            } else if (child.getVal() < current.getVal()) {
                return getParentTreeNode(current.getLeft(), child);
            }
        }
        if (current.getRight() != null) {
            if (current.getRight().getVal() == child.getVal()) {
                return current;
            } else if (child.getVal() > current.getVal()) {
                return getParentTreeNode(current.getRight(), child);
            }
        }
        return null;
    }

    private TreeNode getTreeNodeWithValue(TreeNode current, int nodeValue) {
        if (current == null) {
            return null;
        }

        if (nodeValue == current.getVal()) {
            return current;
        }

        if (nodeValue < current.getVal()) {
            return getTreeNodeWithValue(current.getLeft(), nodeValue);
        } else {
            return getTreeNodeWithValue(current.getRight(), nodeValue);
        }
    }
}
