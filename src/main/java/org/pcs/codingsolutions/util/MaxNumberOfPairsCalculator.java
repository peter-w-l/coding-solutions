package org.pcs.codingsolutions.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaxNumberOfPairsCalculator {

    public static int getMaxNumberOfPairsWithSum(int[] nums, int pairSum) {
        var map = new HashMap<Integer, Integer>();
        int numOfOperations = 0;

        for (int num : nums) {
            Integer substractionValue = pairSum - num;
            if (substractionValue < 0) {
                continue;
            }
            if (map.containsKey(substractionValue)) {
                numOfOperations++;
                var count = map.get(substractionValue);
                count--;
                if (count == 0) {
                    map.remove(substractionValue);
                } else {
                    map.put(substractionValue, count);
                }
            } else {
                var count = map.get(num);
                if (count == null) {
                    count = 1;
                } else {
                    count ++;
                }
                // var count = map.computeIfAbsent(num, key -> 0) + 1;
                map.put(num, count);
            }
        }
        return numOfOperations;
    }

}
