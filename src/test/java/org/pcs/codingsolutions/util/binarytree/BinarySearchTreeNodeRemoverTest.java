package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeNodeRemoverTest {


    @ParameterizedTest
    @MethodSource
    void testDeleteNode(Integer[] sortedTreeValues,
                        int key,
                        Integer[] expectedValues) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(sortedTreeValues);
        TreeNode expected = TreeNodeRootBuilder.buildTreeNodeRoot(expectedValues);

        // when
        TreeNode actual = BinarySearchTreeNodeRemover.deleteNode(root, key);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testDeleteNode() {
        return Stream.of(
                Arguments.of(new Integer[]{5, 3, 6, 2, 4, null, 7}, 3, new Integer[]{5, 4, 6, 2, null, null, 7}),
                Arguments.of(new Integer[]{5, 3, 6, 2, 4, null, 7}, 0, new Integer[]{5, 3, 6, 2, 4, null, 7}),
                Arguments.of(new Integer[]{}, 0, new Integer[]{}),
                Arguments.of(new Integer[]{0}, 0, new Integer[]{}),
                Arguments.of(new Integer[]{50, 30, 70, null, 40, 60, 80}, 50, new Integer[]{70, 60, 80, 30, null, null, null, null, 40})
        );
    }
}