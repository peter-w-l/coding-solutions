package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeMinDiffCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMinimumDifference(Integer[] sortedTreeValues, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(sortedTreeValues);

        // when
        int actual = BinarySearchTreeMinDiffCalculator.getMinimumDifference(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMinimumDifference() {
        return Stream.of(
                Arguments.of(new Integer[]{4, 2, 6, 1, 3}, 1),
                Arguments.of(new Integer[]{1, 0, 48, null, null, 12, 49}, 1)
        );
    }
}