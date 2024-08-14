package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BucketsDistributionCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testDistributeAndGetMaxUnfairness(int[] availableAmount, int bucketsNumber, int expected) {
        // when
        int actual = BucketsDistributionCalculator.distributeAndGetMinUnfairness(availableAmount, bucketsNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testDistributeAndGetMaxUnfairness() {
        return Stream.of(
                Arguments.of(new int[]{8, 15, 10, 20, 8}, 2, 31),
                Arguments.of(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3, 7)
        );
    }
}