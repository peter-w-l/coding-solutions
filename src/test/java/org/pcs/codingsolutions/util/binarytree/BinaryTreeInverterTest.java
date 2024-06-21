package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeInverterTest {

    @ParameterizedTest
    @MethodSource
    void testInvertTree(Integer[] tree, Integer[] expectedTree) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);
        TreeNode expected = TreeNodeRootBuilder.buildTreeNodeRoot(expectedTree);

        // when
        TreeNode actual = BinaryTreeInverter.invertTree(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testInvertTree() {
        return Stream.of(
                Arguments.of(new Integer[]{4, 2, 7, 1, 3, 6, 9}, new Integer[]{4, 7, 2, 9, 6, 3, 1}),
                Arguments.of(new Integer[]{2, 1, 3}, new Integer[]{2, 3, 1}),
                Arguments.of(new Integer[]{}, new Integer[]{})
        );
    }
}