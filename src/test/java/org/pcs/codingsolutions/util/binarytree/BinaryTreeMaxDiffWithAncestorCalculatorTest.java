package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMaxDiffWithAncestorCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxDiffWithAncestor(Integer[] tree, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreeMaxDiffWithAncestorCalculator.getMaxDiffWithAncestor(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxDiffWithAncestor() {
        return Stream.of(
                Arguments.of(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13}, 7),
                Arguments.of(new Integer[]{1, null, 2, null, 0, 3}, 3)
        );
    }
}