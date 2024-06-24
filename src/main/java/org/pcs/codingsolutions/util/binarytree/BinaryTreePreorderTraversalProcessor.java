package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Root -> Left -> Right
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreePreorderTraversalProcessor {

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> values = new ArrayList<>();
        preorderTraversal(root, values);
        return values;
    }

    private static void preorderTraversal(TreeNode treeNode, List<Integer> values) {
        if (treeNode == null) {
            return;
        }

        values.add(treeNode.getVal());
        preorderTraversal(treeNode.getLeft(), values);
        preorderTraversal(treeNode.getRight(), values);
    }
}
