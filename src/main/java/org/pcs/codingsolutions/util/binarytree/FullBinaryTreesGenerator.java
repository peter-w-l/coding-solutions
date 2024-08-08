package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for:
 * <p>
 * Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
 * Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 */
@UtilityClass
public class FullBinaryTreesGenerator {
    public List<TreeNode> generateAllPossibleFBT(int n) {
        if (n % 2 == 0) {
            return List.of();
        }
        Map<Integer, List<TreeNode>> cache = new HashMap<>();
        cache.put(1, List.of(new TreeNode(0, null, null)));
        generateAllPossibleFBT(n, cache);
        return cache.get(n);
    }


    private List<TreeNode> generateAllPossibleFBT(int n, Map<Integer, List<TreeNode>> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        List<TreeNode> results = new ArrayList<>();
        for (int i = 1; i < n; i+=2) {
            List<TreeNode> left = generateAllPossibleFBT(i, cache);
            List<TreeNode> right = generateAllPossibleFBT(n - i - 1, cache);
            for(TreeNode leftNode: left) {
                for(TreeNode rightNode : right) {
                    TreeNode root = TreeNode.builder()
                            .left(leftNode)
                            .right(rightNode)
                            .val(0)
                            .build();
                    results.add(root);
                }
            }
        }

        cache.put(n, results);

        return results;
    }
}
