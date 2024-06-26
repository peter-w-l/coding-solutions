package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

@UtilityClass
public class BinaryTreeZigZagPathCalculator {
    public int getLongestZigZagPath(TreeNode root) {
        return Math.max(countZigZagPathEdges(root.getLeft(), Direction.RIGHT, 1),
                countZigZagPathEdges(root.getRight(), Direction.LEFT, 1));
    }

    private int countZigZagPathEdges(TreeNode treeNode, Direction nextDirection, int numberOfEdgesSoFar) {
        if (treeNode == null) {
            return numberOfEdgesSoFar - 1; // last edge leads to an empty node. Exclude it.
        }

        int numberOfEdgesTillLeftChild;
        int numberOfEdgesTillRightChild;
        if (nextDirection == Direction.LEFT) {
            numberOfEdgesTillLeftChild = numberOfEdgesSoFar + 1; // next node in zigzag will be a left child. Increase the counter of edges in path.
            numberOfEdgesTillRightChild = 1; // alternate path will be counted starting from treeNode. Set counter to only one edge.
        } else {
            numberOfEdgesTillLeftChild = 1;
            numberOfEdgesTillRightChild = numberOfEdgesSoFar + 1;
        }

        return Math.max(countZigZagPathEdges(treeNode.getLeft(), Direction.RIGHT, numberOfEdgesTillLeftChild),
                countZigZagPathEdges(treeNode.getRight(), Direction.LEFT, numberOfEdgesTillRightChild));
    }

    private enum Direction {
        LEFT, RIGHT
    }
}
