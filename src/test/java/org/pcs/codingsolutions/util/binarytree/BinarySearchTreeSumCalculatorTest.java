package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeSumCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testAreNodesWithSumExist(Integer[] sortedTreeValues, int targetValue, boolean expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(sortedTreeValues);

        // when
        boolean actual = BinarySearchTreeSumCalculator.areNodesWithSumExist(root, targetValue);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testAreNodesWithSumExist() {
        return Stream.of(
                Arguments.of(new Integer[]{5, 3, 6, 2, 4, null, 7}, 9, true),
                Arguments.of(new Integer[]{5, 3, 6, 2, 4, null, 7}, 28, false),
                Arguments.of(new Integer[]{1}, 2, false)
        );
    }
}