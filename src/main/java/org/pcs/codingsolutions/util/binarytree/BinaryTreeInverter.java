package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreeInverter {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLeaf = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(leftLeaf);
        invertTree(root.getLeft());
        invertTree(root.getRight());

        return root;
    }
}
