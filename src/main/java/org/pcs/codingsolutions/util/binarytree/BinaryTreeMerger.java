package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinaryTreeMerger {
    public static TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) { // if we return just root2 it cause the modification of root2 during modification of
            // returned result. Break this dependency and return completely new object.
            return TreeNode.builder()
                    .val(root2.getVal())
                    .left(merge(null, root2.getLeft()))
                    .right(merge(null, root2.getRight()))
                    .build();
        } else if (root2 == null) {
            return TreeNode.builder()
                    .val(root1.getVal())
                    .left(merge(root1.getLeft(), null))
                    .right(merge(root1.getRight(), null))
                    .build();
        }

        return TreeNode.builder()
                .val(root1.getVal() + root2.getVal())
                .left(merge(root1.getLeft(), root2.getLeft()))
                .right(merge(root1.getRight(), root2.getRight()))
                .build();
    }
}
