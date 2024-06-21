package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LeafSimilarTreesCalculator {
    public static boolean areLeafsSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leftTreeLeafs = getLeafs(root1);
        List<Integer> rightTreeLeafs = getLeafs(root2);

        return leftTreeLeafs.equals(rightTreeLeafs);
    }

    private static List<Integer> getLeafs(TreeNode root) {
        List<Integer> treeLeafs = new ArrayList<>();

        if (root.getLeft() == null && root.getRight() == null) {
            treeLeafs.add(root.getVal());
            return treeLeafs;
        }

        if (root.getLeft() != null) {
            List<Integer> leftTreeLeafs = getLeafs(root.getLeft());
            treeLeafs.addAll(leftTreeLeafs);
        }

        if (root.getRight() != null) {
            List<Integer> rightTreeLeafs = getLeafs(root.getRight());
            treeLeafs.addAll(rightTreeLeafs);
        }
        return treeLeafs;
    }
}
