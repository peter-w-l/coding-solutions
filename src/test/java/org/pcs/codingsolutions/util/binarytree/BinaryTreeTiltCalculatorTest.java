package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTiltCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetTiltSum(Integer[] tree, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreeTiltCalculator.getTiltSum(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetTiltSum() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3}, 1),
                Arguments.of(new Integer[]{4, 2, 9, 3, 5, null, 7}, 15),
                Arguments.of(new Integer[]{21, 7, 14, 1, 1, 2, 2, 3, 3}, 9)
        );
    }
}