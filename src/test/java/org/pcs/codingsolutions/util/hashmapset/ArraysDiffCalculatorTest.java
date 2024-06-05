package org.pcs.codingsolutions.util.hashmapset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ArraysDiffCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetDifference(int[] leftArray, int[] rightArray, List<List<Integer>> expected) {
        // when
        var actual = ArraysDiffCalculator.getDifference(leftArray, rightArray);

        // then
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(expected);
    }

    private static Stream<Arguments> testGetDifference() {
        return Stream.of(
                Arguments.of(
                        new int[] {1,2,3},
                        new int[] {2,4,6},
                        List.of(
                                List.of(1,3),
                                List.of(4,6))),
                Arguments.of(
                        new int[] {1,2,3,3},
                        new int[] {1,1,2,2},
                        List.of(
                                List.of(3),
                                List.of()))
        );
    }
}