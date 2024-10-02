package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxStockProfitWithFeeCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxProfit(int[] pricesPerDay, int transactionFee, int expected) {
        // when
        int actual = MaxStockProfitWithFeeCalculator.getMaxProfit(pricesPerDay, transactionFee);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @SuppressWarnings("not used")
    private static Stream<Arguments> testGetMaxProfit() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2, 8, 4, 9}, 2, 8),
                Arguments.of(new int[]{1, 3, 7, 5, 10, 3}, 3, 6)
        );
    }
}