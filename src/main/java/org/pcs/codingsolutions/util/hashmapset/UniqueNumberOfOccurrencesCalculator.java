package org.pcs.codingsolutions.util.hashmapset;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Solution for:
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique
 * or false otherwise.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UniqueNumberOfOccurrencesCalculator {
    public static boolean isNumberOfOccurrencesUnique(int[] nums) {
        Map<Integer, Long> valueToNumberOfOccurrences = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<Long> uniqueNumberOfOccurrences = new HashSet<>(valueToNumberOfOccurrences.values());
        return uniqueNumberOfOccurrences.size() == valueToNumberOfOccurrences.keySet().size();
    }
}
