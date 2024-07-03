package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeZigZagPathCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetLongestZigZagPath(Integer[] tree, int expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        int actual = BinaryTreeZigZagPathCalculator.getLongestZigZagPath(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetLongestZigZagPath() {
        return Stream.of(
                Arguments.of(new Integer[]{
                        1,
                        1, 1,
                        null, 1, null, null}, 2),
                Arguments.of(new Integer[]{
                        1,
                        2, 3,
                        null, null, null, 4,
                        5, null}, 2),
                Arguments.of(new Integer[]{
                        1,
                        1, 1,
                        1, null, null, null}, 1),
                Arguments.of(new Integer[]{1,
                        null, 1,
                        1, 1,
                        null, null, 1, 1,
                        null, 1}, 3),
                Arguments.of(new Integer[]{1}, 0)
        );
    }
}