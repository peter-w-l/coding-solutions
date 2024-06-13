package org.pcs.codingsolutions.util.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ListItemsSorterTest {

    @ParameterizedTest
    @MethodSource
    void testSortByOddAndEven(int[] inputNodeValues, int[] expectedNodeValues) {
        // given
        ListNode input = buildListNodes(inputNodeValues);
        ListNode expected = buildListNodes(expectedNodeValues);

        // when
        var actual = ListItemsSorter.sortByOddAndEven(input);

        // then
        var actualNodes = toList(actual);
        var expectedNodes = toList(expected);
        assertThat(actualNodes)
                .containsExactlyElementsOf(expectedNodes);
    }

    private static Stream<Arguments> testSortByOddAndEven() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 3, 5, 2, 4})
        );
    }

    @ParameterizedTest
    @MethodSource
    void testReverse(int[] inputNodeValues, int[] expectedNodeValues) {
        // given
        ListNode input = buildListNodes(inputNodeValues);
        ListNode expected = buildListNodes(expectedNodeValues);

        // when
        var actual = ListItemsSorter.reverse(input);

        // then
        var actualNodes = toList(actual);
        var expectedNodes = toList(expected);
        assertThat(actualNodes)
                .containsExactlyElementsOf(expectedNodes);
    }

    private static Stream<Arguments> testReverse() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1})
        );
    }

    private static List<ListNode> toList(ListNode head) {
        var nodes = new ArrayList<ListNode>();
        var currentNode = head;
        while (currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.getNext();
        }
        return nodes;
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