package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 */
@UtilityClass
public class ColorsSorter {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int minValueIndex = 0;
        int maxValueIndex = nums.length - 1;

        int index = 0;
        while (index <= maxValueIndex) {
            if (nums[index] == 0) { // red
                nums[index] = nums[minValueIndex];
                nums[minValueIndex] = 0;
                minValueIndex++;
                index ++;
            } else if (nums[index] == 2) { // blue
                nums[index] = nums[maxValueIndex];
                nums[maxValueIndex] = 2;
                maxValueIndex--;
            } else {
                index++;
            }
        }

    }
}
