package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeModesCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetAllModes(Integer[] tree, int[] expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int[] actual = BinaryTreeModesCalculator.getAllModes(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetAllModes() {
        return Stream.of(
                Arguments.of(new Integer[]{1, null, 2, null, null, 2}, new int[]{2}),
                Arguments.of(new Integer[]{0}, new int[]{0}),
                Arguments.of(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 2, 6}, new int[]{2, 6}),
                Arguments.of(new Integer[]{1, null, 2}, new int[]{1, 2})
        );
    }
}