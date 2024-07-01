package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeRangeSumCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetBSTRangeSum(Integer[] sortedTreeValues, int low, int high, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(sortedTreeValues);

        // when
        int actual = BinarySearchTreeRangeSumCalculator.getBSTRangeSum(root, low, high);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetBSTRangeSum() {
        return Stream.of(
                Arguments.of(new Integer[]{10, 5, 15, 3, 7, null, 18}, 7, 15, 32),
                Arguments.of(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}, 6, 10, 23)
        );
    }
}