package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeCompleteNodesCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testCountNodes(Integer[] treeValues, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(treeValues);

        // when
        int actual = BinaryTreeCompleteNodesCalculator.countNodes(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCountNodes() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3}, 3),
                Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6}, 6),
                Arguments.of(new Integer[]{1}, 1),
                Arguments.of(new Integer[]{}, 0),
                Arguments.of(new Integer[]{1, 2}, 2),
                Arguments.of(new Integer[]{1, 2, 3}, 3),
                Arguments.of(new Integer[]{1, 2, 3, 4}, 4)
        );
    }
}