package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeLowestCommonAncestorDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testGetLowestCommonAncestor(Integer[] tree,
                                     int descendantNode1Value,
                                     int descendantNode2Value,
                                     int expectedLowestCommonAncestorValue) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);
        TreeNode descendantNode1 = TreeNode.builder().val(descendantNode1Value).build();
        TreeNode descendantNode2 = TreeNode.builder().val(descendantNode2Value).build();

        // when
        TreeNode actual = BinaryTreeLowestCommonAncestorDeterminer.getLowestCommonAncestor(root, descendantNode1, descendantNode2);

        // then
        assertThat(actual.getVal()).isEqualTo(expectedLowestCommonAncestorValue);
    }

    private static Stream<Arguments> testGetLowestCommonAncestor() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 5, 1, 3),
                Arguments.of(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 5, 4, 5),
                Arguments.of(new Integer[]{1, 2}, 1, 2, 1),
                Arguments.of(new Integer[]{-1,
                        0, null,
                        1, null, null, null}, 0, 1, 0)
        );
    }
}