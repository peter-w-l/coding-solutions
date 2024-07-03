package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeInorderTraversalProcessorTest {

    @ParameterizedTest
    @MethodSource
    void testInorderTraversal(Integer[] tree, List<Integer> expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        List<Integer> actual = BinaryTreeInorderTraversalProcessor.inorderTraversal(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testInorderTraversal() {
        return Stream.of(
                Arguments.of(new Integer[]{1, null, 2, 3}, List.of(1, 3, 2)),
                Arguments.of(new Integer[]{}, List.of()),
                Arguments.of(new Integer[]{1}, List.of(1)),
                Arguments.of(new Integer[]{0, -10, 5, null, -3, null, 9}, List.of(-10, -3, 0, 5, 9))
        );
    }
}