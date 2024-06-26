package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
@UtilityClass
public class BinaryTreeLowestCommonAncestorDeterminer {
    public TreeNode getLowestCommonAncestor(TreeNode root,
                                            TreeNode descendantNode1,
                                            TreeNode descendantNode2) {
        if (root == null) {
            return null;
        }
        if (root.getVal() == descendantNode1.getVal()
                || root.getVal() == descendantNode2.getVal()) {
            return root;
        }

        TreeNode descendantInLeftTreeNode = getLowestCommonAncestor(root.getLeft(), descendantNode1, descendantNode2);
        TreeNode descendantInRightTreeNode = getLowestCommonAncestor(root.getRight(), descendantNode1, descendantNode2);

        if (descendantInLeftTreeNode != null && descendantInRightTreeNode != null) {
            return root;
        }

        return descendantInLeftTreeNode == null ? descendantInRightTreeNode : descendantInLeftTreeNode; // can return null
    }

}
