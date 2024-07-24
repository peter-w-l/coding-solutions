package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Solution for:
 * <p>
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 * Return the sorted array.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
@UtilityClass
public class ArraySorterByFrequency {
    public int[] sortByFrequency(int[] nums) {
        Map<Integer, Integer> numberToFrequency = new HashMap<>();
        for (int num : nums) {
            numberToFrequency.merge(num, 1, Integer::sum);
        }

        var numberWithFrequencyComparator = Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue)
                .thenComparing(Comparator.comparingInt(Map.Entry<Integer, Integer>::getKey).reversed());

        return numberToFrequency.entrySet().stream()
                .sorted(numberWithFrequencyComparator)
                .flatMap(numberToFrequencyEntry -> IntStream.range(0, numberToFrequencyEntry.getValue())
                        .mapToObj(i -> numberToFrequencyEntry.getKey()))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
