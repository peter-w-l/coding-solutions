package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeBalancingPerformerTest {

    @ParameterizedTest
    @MethodSource
    void testBalanceBST(Integer[] treeValues, Integer[] expectedTreeValues) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(treeValues);
        TreeNode expected = TreeNodeRootBuilder.buildTreeNodeRoot(expectedTreeValues);

        // when
        TreeNode actual = BinarySearchTreeBalancingPerformer.balanceBST(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testBalanceBST() {
        return Stream.of(
                Arguments.of(new Integer[]{1, null, 15, 14, 17, 7, null, null, null, 2, 12, null, 3, 9, null, null, null, null, 11},
                        new Integer[]{9, 2, 14, 1, 3, 11, 15, null, null, null, 7, null, 12, null, 17}),
                Arguments.of(new Integer[]{1,
                        null, 2,
                        null, 3,
                        null, 4}, new Integer[]{2, 1, 3, null, null, null, 4}),
                Arguments.of(new Integer[]{2, 1, 3}, new Integer[]{2, 1, 3}),
                Arguments.of(new Integer[]{2, 1, 3}, new Integer[]{2, 1, 3})
        );
    }
}