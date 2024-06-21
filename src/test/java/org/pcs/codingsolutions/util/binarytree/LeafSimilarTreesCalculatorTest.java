package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LeafSimilarTreesCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testAreLeafsSimilar(Integer[] root1Values, Integer[] root2Values, boolean expected) {
        // given
        TreeNode root1 = TreeNodeRootBuilder.buildTreeNodeRoot(root1Values);
        TreeNode root2 = TreeNodeRootBuilder.buildTreeNodeRoot(root2Values);

        // when
        boolean actual = LeafSimilarTreesCalculator.areLeafsSimilar(root1, root2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testAreLeafsSimilar() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4},
                        new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8},
                        true),
                Arguments.of(
                        new Integer[]{1, 2, 3},
                        new Integer[]{1, 3, 2},
                        false),
                Arguments.of(
                        new Integer[]{1, 2},
                        new Integer[]{2, 2},
                        true)
        );
    }
}