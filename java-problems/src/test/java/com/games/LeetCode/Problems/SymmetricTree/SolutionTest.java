package com.games.LeetCode.Problems.SymmetricTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testSymmetricTree() {
//        [1,2,2,2,null,2]
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(2);
        treeNode.right.left = new TreeNode(2);
        assertFalse(new Solution().isSymmetric(treeNode));
    }

    @Test
    void testSymmetricTree2() {
//[1,2,2,3,4,4,3]
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        assertTrue(new Solution().isSymmetric(treeNode));
    }
}