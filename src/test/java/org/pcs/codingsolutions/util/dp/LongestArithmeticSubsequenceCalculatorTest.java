package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestArithmeticSubsequenceCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetLongestArithmeticSubSequenceLength(int[] input, int expected) {
        // when
        int actual = LongestArithmeticSubsequenceCalculator.getLongestArithmeticSubSequenceLength(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Example 1:
     * Input: nums = [3,6,9,12]
     * Output: 4
     * Explanation:  The whole array is an arithmetic sequence with steps of length = 3.
     * <p>
     * Example 2:
     * Input: nums = [9,4,7,2,10]
     * Output: 3
     * Explanation:  The longest arithmetic subsequence is [4,7,10].
     * <p>
     * Example 3:
     * Input: nums = [20,1,15,3,10,5,8]
     * Output: 4
     * Explanation:  The longest arithmetic subsequence is [20,15,10,5].
     */
    @SuppressWarnings("unused")
    private static Stream<Arguments> testGetLongestArithmeticSubSequenceLength() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 9, 12}, 4),
                Arguments.of(new int[]{9, 4, 7, 2, 10}, 3),
                Arguments.of(new int[]{20, 1, 15, 3, 10, 5, 8}, 4)
        );
    }
}