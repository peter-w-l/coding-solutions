package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 * If the tree has more than one mode, return them in any order.
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
@UtilityClass
public class BinaryTreeModesCalculator {
    public int[] getAllModes(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return new int[]{root.getVal()};
        }

        List<Integer> mostFrequentValues = new ArrayList<>();
        int[] prevValue = new int[]{Integer.MIN_VALUE};
        int[] prevValueFrequency = new int[]{0};
        int[] maxFrequencySoFar = new int[]{1}; // in case there are only distinct values
        inOrderTraversal(root, prevValue, prevValueFrequency, maxFrequencySoFar, mostFrequentValues);

        return mostFrequentValues.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderTraversal(TreeNode treeNode,
                                  int[] prevValue,
                                  int[] prevValueFrequency,
                                  int[] maxFrequencySoFar,
                                  List<Integer> mostFrequentValues) {
        if (treeNode == null) {
            return;
        }

        inOrderTraversal(
                treeNode.getLeft(),
                prevValue,
                prevValueFrequency,
                maxFrequencySoFar,
                mostFrequentValues);
        if (treeNode.getVal() == prevValue[0]) { // values here will be ordered as we use in-order traversal method
            prevValueFrequency[0]++;
            if (prevValueFrequency[0] == maxFrequencySoFar[0]) {
                mostFrequentValues.add(prevValue[0]);
            } else if (prevValueFrequency[0] > maxFrequencySoFar[0]) {
                mostFrequentValues.clear();
                mostFrequentValues.add(prevValue[0]);
                maxFrequencySoFar[0] = prevValueFrequency[0];
            }
        } else {
            prevValue[0] = treeNode.getVal();
            prevValueFrequency[0] = 1;
            if (maxFrequencySoFar[0] == 1) { // so far there are only distinct values
                mostFrequentValues.add(prevValue[0]);
            }
        }
        inOrderTraversal(
                treeNode.getRight(),
                prevValue,
                prevValueFrequency,
                maxFrequencySoFar,
                mostFrequentValues);
    }
}
