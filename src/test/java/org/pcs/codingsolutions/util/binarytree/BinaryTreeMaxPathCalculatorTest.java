package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMaxPathCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxNumberOfEdges(Integer[] treeValues, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(treeValues);

        // when
        int actual = BinaryTreeMaxPathCalculator.getMaxNumberOfEdges(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxNumberOfEdges() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4, 5}, 3),
                Arguments.of(new Integer[]{1, 2}, 1)
        );
    }
}