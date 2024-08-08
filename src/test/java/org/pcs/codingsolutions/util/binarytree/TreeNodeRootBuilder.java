package org.pcs.codingsolutions.util.binarytree;

import org.pcs.codingsolutions.model.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class TreeNodeRootBuilder {
    private TreeNodeRootBuilder() {
    }

    static TreeNode buildTreeNodeRoot(List<Integer> tree) {
        if (tree.isEmpty()) {
            return null;
        }

        return buildTreeNodeRoot(toQueue(tree));
    }

    static TreeNode buildTreeNodeRoot(Integer[] tree) {
        if (tree.length == 0) {
            return null;
        }
        return buildTreeNodeRoot(toQueue(tree));
    }

    private static TreeNode buildTreeNodeRoot(Queue<Integer> values) {
        TreeNode root = buildTreeNode(values.poll());
        Queue<TreeNode> levelTreeNodes = new LinkedList<>();
        levelTreeNodes.offer(root);
        while (!levelTreeNodes.isEmpty()) {
            int levelNodesNumber = levelTreeNodes.size();
            while (levelNodesNumber > 0) {
                TreeNode treeNode = levelTreeNodes.poll();
                if (treeNode != null) {
                    treeNode.setLeft(buildTreeNode(values.poll()));
                    treeNode.setRight(buildTreeNode(values.poll()));
                    levelTreeNodes.offer(treeNode.getLeft());
                    levelTreeNodes.offer(treeNode.getRight());
                }

                levelNodesNumber--;
            }
        }

        return root;
    }

    private static Queue<Integer> toQueue(Integer[] array) {
        Queue<Integer> values = new LinkedList<>();
        for (Integer value : array) {
            values.offer(value);
        }
        return values;
    }

    private static Queue<Integer> toQueue(List<Integer> list) {
        Queue<Integer> values = new LinkedList<>();
        for (Integer value : list) {
            values.offer(value);
        }
        return values;
    }

    private static TreeNode buildTreeNode(Integer value) {
        return value == null ? null : TreeNode.builder()
                .val(value)
                .build();
    }
}
