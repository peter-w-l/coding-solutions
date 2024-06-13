package org.pcs.codingsolutions.util.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListMiddleCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMiddleNode(int[] inputNodeValues, int[] expectedNodeValues) {
        // given
        ListNode input = buildListNodes(inputNodeValues);
        ListNode expected = buildListNodes(expectedNodeValues);

        // when
        var actual = LinkedListMiddleCalculator.getMiddleNode(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMiddleNode() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{4, 5, 6})
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