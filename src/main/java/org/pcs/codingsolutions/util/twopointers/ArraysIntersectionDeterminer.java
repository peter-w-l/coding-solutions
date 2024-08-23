package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
@UtilityClass
public class ArraysIntersectionDeterminer {
    public int[] getIntersection(int[] array1, int[] array2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(array1);
        Arrays.sort(array2);
        int array1Index = 0;
        int array2Index = 0;
        int prevValue = -1;
        int array1Length = array1.length;
        int array2Length = array2.length;
        while (array1Index < array1Length && array2Index < array2Length) {
            if (array1[array1Index] < array2[array2Index]) {
                array1Index ++;
            } else if (array1[array1Index] > array2[array2Index]) {
                array2Index ++;
            } else {
                if (array2[array2Index] != prevValue) {
                    prevValue = array2[array2Index];
                    result.add(prevValue);
                }
                array1Index ++;
                array2Index ++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
