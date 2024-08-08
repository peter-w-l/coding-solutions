package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FullBinaryTreesGeneratorTest {

    @ParameterizedTest
    @MethodSource
    void testGenerateAllPossibleFBT(int input, List<List<Integer>> expectedTree) {
        // given

        List<TreeNode> expected = expectedTree.stream().map(TreeNodeRootBuilder::buildTreeNodeRoot).toList();

        // when
        List<TreeNode> actual = FullBinaryTreesGenerator.generateAllPossibleFBT(input);

        // then
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> testGenerateAllPossibleFBT() {
        return Stream.of(
                Arguments.of(7, List.of(
                        toList(0, 0, 0, null, null, 0, 0, null, null, 0, 0),
                        toList(0, 0, 0, null, null, 0, 0, 0, 0),
                        toList(0, 0, 0, 0, 0, 0, 0),
                        toList(0, 0, 0, 0, 0, null, null, null, null, 0, 0),
                        toList(0, 0, 0, 0, 0, null, null, 0, 0))),
                Arguments.of(3, List.of(List.of(0, 0, 0))));
    }

    private static <T> List<T> toList(T... elements) {
        return Arrays.stream(elements).toList();
    }
}