package org.pcs.codingsolutions.util.binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMaxDepthCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxDepth(Integer[] tree, int expected) {
        // given
        TreeNode root = buildRoot(tree);

        // when
        int actual = BinaryTreeMaxDepthCalculator.getMaxDepth(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxDepth() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 9, 20, null, null, 15, 7}, 3),
                Arguments.of(new Integer[]{1, null, 2}, 2)
        );
    }

    private TreeNode buildRoot(Integer[] tree) {
        var root = buildTreeNode(tree[0]);

        List<TreeNode> prevLevelLeafs = List.of(root);
        int index = 1;

        while (index < tree.length && containsNonEmptyNodes(prevLevelLeafs)) {
            int levelLeafsCount = prevLevelLeafs.size() * 2;
            List<TreeNode> levelLeafs = new ArrayList<>(levelLeafsCount);
            for (int i = 0; i < levelLeafsCount; i++) {
                levelLeafs.add(buildTreeNode(tree[index + i]));
            }
            int leafIndex = 0;
            for (TreeNode parent : prevLevelLeafs) {
                if (parent != null) {
                    parent.setLeft(levelLeafs.get(leafIndex));
                    parent.setRight(levelLeafs.get(leafIndex + 1));
                }
                leafIndex += 2;
            }
            index += levelLeafs.size();
            prevLevelLeafs = levelLeafs;
        }
        return root;
    }

    private boolean containsNonEmptyNodes(List<TreeNode> levelNodes) {
        return levelNodes.stream()
                .anyMatch(Objects::nonNull);
    }

    private TreeNode buildTreeNode(Integer value) {
        return value == null ? null : TreeNode.builder()
                .val(value)
                .build();
    }
}