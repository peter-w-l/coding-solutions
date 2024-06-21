package org.pcs.codingsolutions.util.binarytree;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.TreeNode;

/**
 * Solution for:
 * <p>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BinarySearchTreeConverter {
    public static TreeNode convertSortedArrayToBST(int[] sortedArray) {

        return buildMiddle(sortedArray, 0, sortedArray.length - 1);
    }

    private static TreeNode buildMiddle(int[] sortedArray, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return null;
        }

        int middleIndex = (beginIndex + endIndex) / 2;
        TreeNode left = buildMiddle(sortedArray, beginIndex, middleIndex - 1);
        TreeNode right = buildMiddle(sortedArray, middleIndex + 1, endIndex);

        return TreeNode.builder()
                .val(sortedArray[middleIndex])
                .left(left)
                .right(right)
                .build();
    }
}
