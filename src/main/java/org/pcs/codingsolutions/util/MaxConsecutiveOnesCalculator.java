package org.pcs.codingsolutions.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxConsecutiveOnesCalculator {
    public static int getMaxNumberOfOnesWithFlippingNumber(int[] nums, int flippingLimit) {
        int maxNumberOfOnes = 0;
        int numberOfFlipped = 0;
        int leftIndex = 0;
        for (int rightIndex = 0; rightIndex < nums.length; rightIndex ++) {
            if (nums[rightIndex] == 0) {
                numberOfFlipped ++;
            }

            // move left index to the right (if needed)
            while(numberOfFlipped > flippingLimit) {
                if (nums[leftIndex] != 1) {
                    numberOfFlipped --;
                }
                leftIndex ++;
            }

            int numberOfOnes = rightIndex - leftIndex + 1;
            maxNumberOfOnes = Math.max(maxNumberOfOnes, numberOfOnes);
        }
        return maxNumberOfOnes; // time complexity is O(N). Space complexity is O(1).
    }
}
