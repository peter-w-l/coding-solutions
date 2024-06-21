package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BalancedBinaryTreeDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testIsBalanced(Integer[] tree, boolean expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        boolean actual = BalancedBinaryTreeDeterminer.isBalanced(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testIsBalanced() {
        return Stream.of(
                Arguments.of(new Integer[]{3,9,20,null,null,15,7}, true),
                Arguments.of(new Integer[]{1,2,2,3,3,null,null,4,4}, false),
                Arguments.of(new Integer[]{}, true),
                Arguments.of(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null,null,null,null,null, 4}, false)
        );
    }
}