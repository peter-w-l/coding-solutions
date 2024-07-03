package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumBinaryTreeComposerTest {

    @ParameterizedTest
    @MethodSource
    void testConstructMaximumBinaryTree(int[] nums, Integer[] expectedValues) {
        // given
        TreeNode expected = TreeNodeRootBuilder.buildTreeNodeRoot(expectedValues);

        // when
        TreeNode actual = MaximumBinaryTreeComposer.constructMaximumBinaryTree(nums);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    private static Stream<Arguments> testConstructMaximumBinaryTree() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 2, 1, 6, 0, 5},
                        new Integer[]{6,
                                3, 5,
                                null, 2, 0, null,
                                null, 1}),
                Arguments.of(
                        new int[]{3, 2, 1},
                        new Integer[]{3, null, 2, null, 1})
        );
    }
}