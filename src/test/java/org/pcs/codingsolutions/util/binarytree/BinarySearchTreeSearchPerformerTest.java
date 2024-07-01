package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeSearchPerformerTest {

    @ParameterizedTest
    @MethodSource
    void testSearchBSTNodeWithValue(Integer[] sortedTreeValues, int targetValue, Integer[] expectedValues) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(sortedTreeValues);
        TreeNode expected = TreeNodeRootBuilder.buildTreeNodeRoot(expectedValues);

        // when
        TreeNode actual = BinarySearchTreeSearchPerformer.searchBSTNodeWithValue(root, targetValue);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testSearchBSTNodeWithValue() {
        return Stream.of(
                Arguments.of(new Integer[]{4, 2, 7, 1, 3}, 2, new Integer[]{2, 1, 3}),
                Arguments.of(new Integer[]{4, 2, 7, 1, 3}, 5, new Integer[]{})
        );
    }
}