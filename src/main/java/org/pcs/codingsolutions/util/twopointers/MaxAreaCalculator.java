package org.pcs.codingsolutions.util.twopointers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Solution for:
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxAreaCalculator {
    public static int getMaxArea(int[] height) {
        int max = 0;
        int leftIndex = 0;

        int heightLength = height.length;
        int rightIndex = heightLength - 1;

        while (rightIndex > leftIndex) {

            int amount = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            if (max < amount) {
                max = amount;
            }

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex ++;
            } else {
                rightIndex --;
            }
        }
        return max; // time complexity is O(n). Space: O(1);
    }
}
