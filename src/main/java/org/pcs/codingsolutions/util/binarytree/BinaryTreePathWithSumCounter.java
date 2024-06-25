package org.pcs.codingsolutions.util.binarytree;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class BinaryTreePathWithSumCounter {
    public static int countSubPathsWithValuesSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, targetSum, map, 0L);
    }

    private static int dfs(TreeNode treeNode, int targetSum, Map<Long, Integer> map, long prefixSum) {
        if (treeNode == null) {
            return 0;
        }

        long sum = prefixSum + treeNode.getVal();

        int count = map.getOrDefault(sum - targetSum, 0); // if sum > targetSum and some previous sub path contains the difference
        map.merge(sum, 1, Integer::sum);

        count += dfs(treeNode.getLeft(), targetSum, map, sum);
        count += dfs(treeNode.getRight(), targetSum, map, sum);

        map.put(sum, map.get(sum) - 1);

        return count;
    }

//    public static int countSubPathsWithValuesSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return 0;
//        }
//
//        return countSubPathsWithValuesSumFromNode(root, targetSum)
//                + countSubPathsWithValuesSum(root.getLeft(), targetSum)
//                + countSubPathsWithValuesSum(root.getRight(), targetSum);
//    }
//
//    private static int countSubPathsWithValuesSumFromNode(TreeNode treeNode, int targetSum) {
//        if (treeNode == null) {
//            return 0;
//        }
//
//        return (treeNode.getVal() == targetSum ? 1 : 0)
//                + countSubPathsWithValuesSumFromNode(treeNode.getLeft(), targetSum - treeNode.getVal())
//                + countSubPathsWithValuesSumFromNode(treeNode.getRight(), targetSum - treeNode.getVal());
//    }
}
