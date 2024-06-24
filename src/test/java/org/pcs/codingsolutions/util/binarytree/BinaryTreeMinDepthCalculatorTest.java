package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMinDepthCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMinDepth(Integer[] tree, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreeMinDepthCalculator.getMinDepth(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMinDepth() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 9, 20, null, null, 15, 7}, 2),
                Arguments.of(new Integer[]{2, null, 3, null, null, null, 4, null, null, null, null, null, null, null, 5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 6}, 5)
        );
    }
}