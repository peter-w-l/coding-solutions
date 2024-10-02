package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxStockProfitWithCooldownCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxProfit(int[] input, int expected) {
        // when
        int actual = MaxStockProfitWithCooldownCalculator.getMaxProfit(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @SuppressWarnings("not used")
    private static Stream<Arguments> testGetMaxProfit() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 2}, 3),
                Arguments.of(new int[]{1}, 0)
        );
    }
}