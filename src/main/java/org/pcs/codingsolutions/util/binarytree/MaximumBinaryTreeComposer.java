package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively
 * from nums using the following algorithm:
 * <p>
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * All integers in nums are unique.
 */
@UtilityClass
public class MaximumBinaryTreeComposer {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int beginIndexInclusive, int endIndexInclusive) {
        if (beginIndexInclusive > endIndexInclusive) {
            return null;
        }
        if (beginIndexInclusive == endIndexInclusive) {
            return new TreeNode(nums[beginIndexInclusive], null, null);
        }
        int maxIndex = getMaxNumberIndex(nums, beginIndexInclusive, endIndexInclusive);
        TreeNode currentNode = new TreeNode(nums[maxIndex], null, null);
        TreeNode leftNode = constructMaximumBinaryTree(nums, beginIndexInclusive, maxIndex - 1);
        TreeNode rightNode = constructMaximumBinaryTree(nums, maxIndex + 1, endIndexInclusive);
        currentNode.setLeft(leftNode);
        currentNode.setRight(rightNode);

        return currentNode;
    }

    private int getMaxNumberIndex(int[] nums, int beginIndexInclusive, int endIndexInclusive) {
        int maxValue = -1;
        int maxValueIndex = -1;
        for (int i = beginIndexInclusive; i <= endIndexInclusive; i++) {
            if (nums[i] > maxValue) {
                maxValueIndex = i;
                maxValue = nums[i];
            }
        }
        return maxValueIndex;
    }
}
