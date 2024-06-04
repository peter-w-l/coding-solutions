package org.pcs.codingsolutions.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
