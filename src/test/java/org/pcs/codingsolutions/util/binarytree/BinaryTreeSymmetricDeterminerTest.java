package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeSymmetricDeterminerTest {
    @ParameterizedTest
    @MethodSource
    void testIsSymmetric(Integer[] tree, boolean expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        boolean actual = BinaryTreeSymmetricDeterminer.isSymmetric(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testIsSymmetric() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 2, 3, 4, 4, 3}, true),
                Arguments.of(new Integer[]{1, 2, 2, null, 3, null, 3}, false)
        );
    }
}