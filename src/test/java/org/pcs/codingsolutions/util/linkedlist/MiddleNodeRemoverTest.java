package org.pcs.codingsolutions.util.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MiddleNodeRemoverTest {

    @ParameterizedTest
    @MethodSource
    void testDeleteMiddleNode(int[] inputNodeValues, int[] expectedNodeValues) {
        // given
        ListNode input = buildListNodes(inputNodeValues);
        ListNode expected = buildListNodes(expectedNodeValues);

        // when
        var actual = MiddleNodeRemover.deleteMiddleNode(input);

        // then
        var actualNodes = toList(actual);
        var expectedNodes = toList(expected);
        assertThat(actualNodes)
                .containsExactlyElementsOf(expectedNodes);
    }

    private static Stream<Arguments> testDeleteMiddleNode() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 7, 1, 2, 6}, new int[]{1, 3, 4, 1, 2, 6}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{2, 1}, new int[]{2})
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