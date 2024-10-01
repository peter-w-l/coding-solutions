package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxStockProfitCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxProfit(int numberOfTransactionsAllowed, int[] pricesPerDay, int expected) {
        // when
        int actual = MaxStockProfitCalculator.getMaxProfit(numberOfTransactionsAllowed, pricesPerDay);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @SuppressWarnings("not used")
    private static Stream<Arguments> testGetMaxProfit() {
        return Stream.of(
                Arguments.of(2, new int[]{2, 4, 1}, 2),
                Arguments.of(2, new int[]{3, 2, 6, 5, 0, 3}, 7),
                Arguments.of(2, new int[]{2,1,4,5,2,9,7}, 11),
                Arguments.of(2, new int[]{1,2,4,2,5,7,2,4,9,0}, 13)
        );
    }
}