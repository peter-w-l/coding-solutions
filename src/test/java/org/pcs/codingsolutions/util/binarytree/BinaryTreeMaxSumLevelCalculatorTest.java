package org.pcs.codingsolutions.util.binarytree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

class BinaryTreeMaxSumLevelCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetLevelWithMaxSum(Integer[] treeValues, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(treeValues);

        // when
        int actual = BinaryTreeMaxSumLevelCalculator.getLevelWithMaxSum(root);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetLevelWithMaxSum() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 7, 0, 7, -8, null, null}, 2),
                Arguments.of(new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127}, 2)
        );
    }
}