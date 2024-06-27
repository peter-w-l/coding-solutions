package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
 * structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree could also be considered as a subtree of itself.
 */
@UtilityClass
public class BinaryTreeSubtreeExistenceDeterminer {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot)
                || isSubtree(root.getLeft(), subRoot)
                || isSubtree(root.getRight(), subRoot);
    }

    private boolean isSameTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null) {
            return treeNode1 == null && treeNode2 == null;
        }

        return treeNode1.getVal() == treeNode2.getVal()
                && isSameTree(treeNode1.getLeft(), treeNode2.getLeft())
                && isSameTree(treeNode1.getRight(), treeNode2.getRight());
    }
}
