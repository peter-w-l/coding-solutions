package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeSubtreeExistenceDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testIsSubtree(Integer[] tree, Integer[] subTree, boolean expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);
        TreeNode subRoot = TreeNodeRootBuilder.buildTreeNodeRoot(subTree);

        // when
        boolean actual = BinaryTreeSubtreeExistenceDeterminer.isSubtree(root, subRoot);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testIsSubtree() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 4, 5, 1, 2}, new Integer[]{4, 1, 2}, true),
                Arguments.of(new Integer[]{3,
                        4, 5,
                        1, 2, null, null,
                        null, null, 0}, new Integer[]{4, 1, 2}, false)
        );
    }
}