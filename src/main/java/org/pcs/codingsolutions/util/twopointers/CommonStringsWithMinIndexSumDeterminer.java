package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for:
 * <p>
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * A common string is a string that appeared in both list1 and list2.
 * A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j]
 * then i + j should be the minimum value among all the other common strings.
 * Return all the common strings with the least index sum. Return the answer in any order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the strings of list1 are unique.
 * All the strings of list2 are unique.
 * There is at least a common string between list1 and list2.
 */
@UtilityClass
public class CommonStringsWithMinIndexSumDeterminer {
    public String[] getCommonStringWithMinIndexSum(String[] list1, String[] list2) {
        Map<String, Integer> stringToIndexSum = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            stringToIndexSum.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> results = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (stringToIndexSum.containsKey(list2[i])) {
                int sum = stringToIndexSum.get(list2[i]) + i;
                if (sum < min) {
                    min = sum;
                    results.clear();
                    results.add(list2[i]);
                } else if (sum == min) {
                    results.add(list2[i]);
                }
            }
        }
        return results.toArray(String[]::new);
    }
}
