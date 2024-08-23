package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortedArraysMergerTest {

    @ParameterizedTest
    @MethodSource
    void testMergeTwoLists(int[] inputNodeValues1, int[] inputNodeValues2, int[] expectedNodeValues) {
        // given
        ListNode expected = buildListNodes(expectedNodeValues);

        // when
        ListNode actual = SortedArraysMerger.mergeTwoLists(buildListNodes(inputNodeValues1), buildListNodes(inputNodeValues2));

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testMergeTwoLists() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{0}, new int[]{0})
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