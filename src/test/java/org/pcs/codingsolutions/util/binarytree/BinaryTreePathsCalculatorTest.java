package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreePathsCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetAllAvailablePaths(Integer[] tree, List<String> expected) {
        // given
        TreeNode root = TreeNodeRootBuilder.buildTreeNodeRoot(tree);

        // when
        List<String> actual = BinaryTreePathsCalculator.getAllAvailablePaths(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetAllAvailablePaths() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, null, 5}, List.of("1->2->5", "1->3")),
                Arguments.of(new Integer[]{1}, List.of("1"))
        );
    }
}