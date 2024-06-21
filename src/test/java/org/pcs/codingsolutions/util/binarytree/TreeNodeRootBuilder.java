package org.pcs.codingsolutions.util.binarytree;

import org.pcs.codingsolutions.model.TreeNode;

public final class TreeNodeRootBuilder {
    private TreeNodeRootBuilder() {
    }

    static TreeNode buildTreeNodeRoot(Integer[] tree) {
        return getTreeNodeForIndex(tree, 0, 1);
    }

    private static TreeNode getTreeNodeForIndex(Integer[] tree, int index, int nodesInLevel) {
        if (index >= tree.length || tree[index] == null) {
            return null;
        }

        int levelFirstElementIndex = getLevelFirstElementIndex(index);
        int diff = index - levelFirstElementIndex;
        int leftIndex = levelFirstElementIndex + (diff * 2) + nodesInLevel;
        TreeNode treeNode = buildTreeNode(tree[index]);
        TreeNode leftLeaf = getTreeNodeForIndex(tree, leftIndex, nodesInLevel * 2);
        TreeNode rightLeaf = getTreeNodeForIndex(tree, leftIndex + 1, nodesInLevel * 2);
        treeNode.setLeft(leftLeaf);
        treeNode.setRight(rightLeaf);
        return treeNode;
    }

    private static int getLevelFirstElementIndex(int index) {
        int levelIndex = 0;
        int nextLevelIndex = 0;
        while (nextLevelIndex <= index) {
            levelIndex = nextLevelIndex;
            nextLevelIndex = nextLevelIndex * 2 + 1;
        }
        return levelIndex;
    }

    private static TreeNode buildTreeNode(Integer value) {
        return value == null ? null : TreeNode.builder()
                .val(value)
                .build();
    }
}
