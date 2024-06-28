package org.pcs.codingsolutions.util.binarytree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
        var prevValueAndFrequency = TreeNodeValueAndFrequency.builder()
                .frequency(new Frequency(0))
                .build();
        var maxFrequency = new Frequency(1); // in case there are only distinct values

        inOrderTraversal(root, prevValueAndFrequency, maxFrequency, mostFrequentValues);

        return mostFrequentValues.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderTraversal(TreeNode treeNode,
                                  TreeNodeValueAndFrequency prevValueAndFrequency,
                                  Frequency maxFrequency,
                                  List<Integer> mostFrequentValues) {
        if (treeNode == null) {
            return;
        }

        inOrderTraversal(
                treeNode.getLeft(),
                prevValueAndFrequency,
                maxFrequency,
                mostFrequentValues);
        if (treeNode.getVal() == prevValueAndFrequency.getValue()) { // values here will be ordered as we use in-order traversal method
            prevValueAndFrequency.setFrequencyValue(prevValueAndFrequency.getFrequencyValue() + 1);
            if (prevValueAndFrequency.getFrequencyValue() == maxFrequency.getValue()) {
                mostFrequentValues.add(prevValueAndFrequency.getValue());
            } else if (prevValueAndFrequency.getFrequencyValue() > maxFrequency.getValue()) {
                mostFrequentValues.clear();
                mostFrequentValues.add(prevValueAndFrequency.getValue());
                maxFrequency.setValue(prevValueAndFrequency.getFrequencyValue());
            }
        } else {
            prevValueAndFrequency.setValue(treeNode.getVal());
            prevValueAndFrequency.setFrequencyValue(1);
            if (maxFrequency.getValue() == 1) { // so far there are only distinct values
                mostFrequentValues.add(prevValueAndFrequency.getValue());
            }
        }
        inOrderTraversal(
                treeNode.getRight(),
                prevValueAndFrequency,
                maxFrequency,
                mostFrequentValues);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    private static class TreeNodeValueAndFrequency {
        private int value;
        private Frequency frequency;

        public int getFrequencyValue() {
            return frequency.getValue();
        }

        public void setFrequencyValue(int frequencyValue) {
            frequency.setValue(frequencyValue);
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    private static class Frequency {
        private int value;
    }
}
