package com.games.LeetCode.Problems.LowestCommonAncestor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testLcaDeepestLeaves() {
        TreeNode treeNode = new Solution().insertLevelOrder(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, new TreeNode(3), 0);
        TreeNode treeNode1 = new Solution().lcaDeepestLeaves(treeNode);
        System.out.println(treeNode1.val);
    }

    @Test
    void testLevelOrderInsertion() {
        TreeNode treeNode = new Solution().insertLevelOrder(new Integer[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}, new TreeNode(3), 0);
        System.out.println(treeNode.val);
    }

}