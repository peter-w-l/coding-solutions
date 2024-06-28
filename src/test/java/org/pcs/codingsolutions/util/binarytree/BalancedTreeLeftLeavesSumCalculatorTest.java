package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BalancedTreeLeftLeavesSumCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testSumLeftLeaves(Integer[] treeValues, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(treeValues);

        // when
        int actual = BalancedTreeLeftLeavesSumCalculator.sumLeftLeaves(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testSumLeftLeaves() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 9, 20, null, null, 15, 7}, 24),
                Arguments.of(new Integer[]{1}, 0)
        );
    }
}