package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CoinChangeCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMinNumOfCoinsForAmount(int[] coins, int amount, int expected) {
        // when
        int actual = CoinChangeCalculator.getMinNumOfCoinsForAmount(coins, amount);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMinNumOfCoinsForAmount() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5}, 11, 3),
                Arguments.of(new int[]{2}, 3, -1),
                Arguments.of(new int[]{1}, 0, 0)
        );
    }
}