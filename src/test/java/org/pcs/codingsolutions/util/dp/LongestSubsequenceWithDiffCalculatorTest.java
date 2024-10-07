package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubsequenceWithDiffCalculatorTest {
    @ParameterizedTest
    @MethodSource
    void testGetLongestSubsequenceWithDiff(int[] array, int diff, int expected) {
        // when
        int actual = LongestSubsequenceWithDiffCalculator.getLongestSubsequenceWithDiff(array, diff);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Example 1:
     * <p>
     * Input: arr = [1,2,3,4], difference = 1
     * Output: 4
     * Explanation: The longest arithmetic subsequence is [1,2,3,4].
     * Example 2:
     * <p>
     * Input: arr = [1,3,5,7], difference = 1
     * Output: 1
     * Explanation: The longest arithmetic subsequence is any single element.
     * Example 3:
     * <p>
     * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
     * Output: 4
     * Explanation: The longest arithmetic subsequence is [7,5,3,1].
     */
    @SuppressWarnings("unused")
    private static Stream<Arguments> testGetLongestSubsequenceWithDiff() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 1, 4),
                Arguments.of(new int[]{1, 3, 5, 7}, 1, 1),
                Arguments.of(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2, 4),
                Arguments.of(new int[]{3, 4, -3, -2, -4}, -5, 2)
        );
    }

}