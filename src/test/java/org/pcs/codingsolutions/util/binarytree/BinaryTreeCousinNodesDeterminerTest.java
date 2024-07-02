package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeCousinNodesDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testAreCousinNodes(Integer[] treeValues, int node1Value, int node2Value, boolean expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(treeValues);

        // when
        boolean actual = BinaryTreeCousinNodesDeterminer.areCousinNodes(root, node1Value, node2Value);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testAreCousinNodes() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4}, 4, 3, false),
                Arguments.of(new Integer[]{1, 2, 3, null, 4, null, 5}, 5, 4, true),
                Arguments.of(new Integer[]{1, 2, 3, null, 4}, 2, 3, false)
        );
    }
}