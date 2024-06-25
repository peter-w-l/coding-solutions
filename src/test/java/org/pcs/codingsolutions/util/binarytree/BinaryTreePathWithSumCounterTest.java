package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreePathWithSumCounterTest {

    @ParameterizedTest
    @MethodSource
    void testCountPathsWithTargetSum(Integer[] tree, int pathSum, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreePathWithSumCounter.countSubPathsWithValuesSum(root, pathSum);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCountPathsWithTargetSum() {
        return Stream.of(
//                Arguments.of(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 8, 3),
//                Arguments.of(new Integer[]{10, 55, -3, 3, 2, null, 11, 33, -2, null, 1}, 91, 1),
//                Arguments.of(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 17, 1),
//                Arguments.of(new Integer[]{10, 5, -3, 3, 2, null, 11, -19, -2, null, 1}, -16, 1),
//                Arguments.of(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}, 22, 3),
//                Arguments.of(new Integer[]{11, 21, 22, 31, 32, 33, 34, 41, 42, 43, 44, 45, 46, 47, 48}, 72, 1),
//                Arguments.of(new Integer[]{11, 21, 22, 31, 32, 33, 34, 41, 42, 43, 44, 45, 46, 47, 48}, 72, 1),
//                Arguments.of(new Integer[]{1}, 0, 0),
                Arguments.of(new Integer[]{0, 1, 1}, 1, 4)
        );
    }
}