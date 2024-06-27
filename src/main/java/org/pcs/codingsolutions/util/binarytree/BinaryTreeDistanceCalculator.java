package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for:
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different
 * nodes in the tree.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 105
 */
@UtilityClass
public class BinaryTreeDistanceCalculator {
    public int getMinDiffInBST(TreeNode root) {
        Queue<Integer> values = new LinkedList<>();
        addAllValuesSortedAsc(root, values);
        return getMinDiffInQueueConsecutiveElements(values); // Since root is BST then values will be sorted after in-order traversal
    }

    private int getMinDiffInQueueConsecutiveElements(Queue<Integer> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("Queue should be non empty.");
        }
        int minDiff = Integer.MAX_VALUE;
        Integer prevValue = values.poll();
        while (values.peek() != null) {
            Integer currentValue = values.poll();
            int diff = currentValue - prevValue;
            minDiff = Math.min(minDiff, diff);
            prevValue = currentValue;
        }
        return minDiff;
    }

    private void addAllValuesSortedAsc(TreeNode treeNode, Queue<Integer> values) { // in-order traversal
        if (treeNode == null) {
            return;
        }
        addAllValuesSortedAsc(treeNode.getLeft(), values);
        values.add(treeNode.getVal());
        addAllValuesSortedAsc(treeNode.getRight(), values);
    }
}
