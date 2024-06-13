package org.pcs.codingsolutions.util.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxTwinSumCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testPairSum(int[] inputNodeValues, int expected) {
        // given
        ListNode input = buildListNodes(inputNodeValues);

        // when
        var actual = MaxTwinSumCalculator.pairSum(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testPairSum() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 2, 1}, 6),
                Arguments.of(new int[]{4, 2, 2, 3}, 7),
                Arguments.of(new int[]{1, 100000}, 100001)
        );
    }

    private static ListNode buildListNodes(int[] values) {
        ListNode nextNode = null;
        for (int i = values.length - 1; i >= 0; i--) {
            nextNode = ListNode.builder()
                    .val(values[i])
                    .next(nextNode)
                    .build();
        }
        return nextNode;
    }
}