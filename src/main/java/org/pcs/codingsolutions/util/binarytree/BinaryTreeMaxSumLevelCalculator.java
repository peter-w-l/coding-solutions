package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
@UtilityClass
public class BinaryTreeMaxSumLevelCalculator {
    public int getLevelWithMaxSum(TreeNode root) {
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);
        int max = root.getVal();
        int levelWithMaxSum = 1;
        int level = 1;
        while (!levelNodes.isEmpty()) {
            int levelNodesAmount = levelNodes.size();
            int levelSum = 0;
            while (levelNodesAmount > 0) {
                TreeNode currentNode = levelNodes.poll();
                levelSum += currentNode.getVal();
                if (currentNode.getLeft() != null) {
                    levelNodes.offer(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    levelNodes.offer(currentNode.getRight());
                }
                levelNodesAmount--;
            }
            if (max < levelSum) {
                levelWithMaxSum = level;
                max = levelSum;
            }
            level++;
        }

        return levelWithMaxSum;
    }
}
