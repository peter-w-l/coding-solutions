package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeConverterTest {

    @ParameterizedTest
    @MethodSource
    void testConvertSortedArrayToBST(int[] sortedArray, Integer[] expectedTree) {
        // given
        TreeNode expected = TreeNodeRootBuilder.buildTreeNodeRoot(expectedTree);

        // when
        TreeNode actual = BinarySearchTreeConverter.convertSortedArrayToBST(sortedArray);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testConvertSortedArrayToBST() {
        return Stream.of(
                Arguments.of(new int[]{-10, -3, 0, 5, 9}, new Integer[]{0, -10, 5, null, -3, null, 9}),
                Arguments.of(new int[]{1, 3}, new Integer[]{1, null, 3})
        );
    }
}