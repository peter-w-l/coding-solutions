package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMergerTest {

    @ParameterizedTest
    @MethodSource
    void testMerge(Integer[] root1Values, Integer[] root2Values, Integer[] expectedValues) {
        // given
        TreeNode root1 = TreeNodeRootBuilder.buildTreeNodeRoot(root1Values);
        TreeNode root2 = TreeNodeRootBuilder.buildTreeNodeRoot(root2Values);
        TreeNode expected = TreeNodeRootBuilder.buildTreeNodeRoot(expectedValues);

        // when
        TreeNode actual = BinaryTreeMerger.merge(root1, root2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testMerge() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 3, 2, 5},
                        new Integer[]{2, 1, 3, null, 4, null, 7},
                        new Integer[]{3, 4, 5, 5, 4, null, 7}),
                Arguments.of(
                        new Integer[]{1},
                        new Integer[]{1, 2},
                        new Integer[]{2, 2})
        );
    }
}