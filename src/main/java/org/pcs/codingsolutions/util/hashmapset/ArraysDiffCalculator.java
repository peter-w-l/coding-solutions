package org.pcs.codingsolutions.util.hashmapset;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;

/**
 * Solution for:
 *
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArraysDiffCalculator {
    public static  List<List<Integer>> getDifference(int[] leftArray, int[] rightArray) {
        var leftArrayNumbers = Arrays.stream(leftArray).boxed().collect(toSet());
        var rightArrayNumbers = Arrays.stream(rightArray).boxed().collect(toSet());
        var leftArrayDiffNumbers = leftArrayNumbers.stream()
                .filter(not(rightArrayNumbers::contains))
                .toList();
        var rightArrayDiffNumbers = rightArrayNumbers.stream()
                .filter(not(leftArrayNumbers::contains))
                .toList();
        return List.of(leftArrayDiffNumbers, rightArrayDiffNumbers); // Time complexity is O(n + m). Space: O(n + m)
    }
}
