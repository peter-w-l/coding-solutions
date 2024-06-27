package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeSecondMinimumNodeCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetSecondMinimumValue(Integer[] tree, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreeSecondMinimumNodeCalculator.getSecondMinimumValue(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetSecondMinimumValue() {
        return Stream.of(
                Arguments.of(new Integer[]{2,
                        2,5,
                        null,null,5,7}, 5),
                Arguments.of(new Integer[]{2,2,2}, -1)
        );
    }
}