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
        List<Integer> firstTreeLeafs = new ArrayList<>();
        List<Integer> secondTreeLeafs = new ArrayList<>();

        extractLeafs(root1, firstTreeLeafs);
        extractLeafs(root2, secondTreeLeafs);

        return firstTreeLeafs.equals(secondTreeLeafs); // Time complexity is O(N). Space complexity is O(N).
    }

    private static void extractLeafs(TreeNode treeNode, List<Integer> treeLeafs) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.getLeft() == null && treeNode.getRight() == null) {
            treeLeafs.add(treeNode.getVal());
            return;
        }

        extractLeafs(treeNode.getLeft(), treeLeafs);
        extractLeafs(treeNode.getRight(), treeLeafs);
    }
}
