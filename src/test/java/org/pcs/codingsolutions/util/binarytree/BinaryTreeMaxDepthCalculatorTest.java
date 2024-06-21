package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMaxDepthCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxDepth(Integer[] tree, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreeMaxDepthCalculator.getMaxDepth(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxDepth() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 9, 20, null, null, 15, 7}, 3)
//                Arguments.of(new Integer[]{1, null, 2}, 2)
        );
    }
}