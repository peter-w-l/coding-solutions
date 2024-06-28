package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution for:
 * <p>
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
@UtilityClass
public class BinaryTreePathsCalculator {
    public List<String> getAllAvailablePaths(TreeNode root) {
        StringBuilder rootPath = new StringBuilder(root.getVal());
        if (root.getLeft() == null && root.getRight() == null) {
            return List.of(rootPath.toString());
        }
        List<String> paths = new LinkedList<>();
        getAllAvailablePaths(root.getLeft(), rootPath, paths);
        getAllAvailablePaths(root.getRight(), rootPath, paths);
        return paths;
    }

    private void getAllAvailablePaths(TreeNode treeNode,
                                     StringBuilder pathSoFar,
                                     List<String> paths) {
        if (treeNode == null) {
            return;
        }

        int parentPathLength = pathSoFar.length();
        pathSoFar.append("->").append(treeNode.getVal());

        if (treeNode.getLeft() == null && treeNode.getRight() == null) { // leaf
            paths.add(pathSoFar.toString());
        } else {
            getAllAvailablePaths(treeNode.getLeft(), pathSoFar, paths);
            getAllAvailablePaths(treeNode.getRight(), pathSoFar, paths);
        }

        pathSoFar.delete(parentPathLength, pathSoFar.length()); // for correct path building at separate tree branches
    }
}
