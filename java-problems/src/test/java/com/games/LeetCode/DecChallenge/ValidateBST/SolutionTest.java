package com.games.LeetCode.DecChallenge.ValidateBST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    void testValidateBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        Assertions.assertFalse(new Solution().isValidBST(root));
    }

    @Test
    void testValidateBST2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Assertions.assertTrue(new Solution().isValidBST(root));
    }

    @Test
    void testValidateBST3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        Assertions.assertFalse(new Solution().isValidBST(root));
    }

    @Test
    void testValidateBST4() {
        TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);
        Assertions.assertFalse(new Solution().isValidBST(root));
    }
}
