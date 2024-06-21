package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreeInorderTraversalProcessor {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        inorderTraversal(treeNode.getLeft(), result);
        result.add(treeNode.getVal());
        inorderTraversal(treeNode.getRight(), result);
    }
}
