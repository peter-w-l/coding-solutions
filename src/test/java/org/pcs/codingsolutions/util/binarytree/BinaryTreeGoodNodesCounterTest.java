package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeGoodNodesCounterTest {

    @ParameterizedTest
    @MethodSource
    void testCountGoodNodes(Integer[] tree, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreeGoodNodesCounter.countGoodNodes(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCountGoodNodes() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 1, 4, 3, null, 1, 5}, 4),
                Arguments.of(new Integer[]{3, 3, null, 4, 2}, 3),
                Arguments.of(new Integer[]{1}, 1),
                Arguments.of(new Integer[]{9, null, 3, null, null, 6}, 1)
        );
    }
}