package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreePathExistenceDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testHasPathWithTargetSum(Integer[] tree, int pathSum, boolean expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        boolean actual = BinaryTreePathExistenceDeterminer.hasPathWithTargetSum(root, pathSum);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testHasPathWithTargetSum() {
        return Stream.of(
                Arguments.of(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}, 22, true),
                Arguments.of(new Integer[]{1, 2, 3}, 5, false),
                Arguments.of(new Integer[]{1, 2, 3, 4, null, 5, 6}, 10, true),
                Arguments.of(new Integer[]{}, 0, false),
                Arguments.of(new Integer[]{-2, null, -3}, -5, true)
        );
    }
}