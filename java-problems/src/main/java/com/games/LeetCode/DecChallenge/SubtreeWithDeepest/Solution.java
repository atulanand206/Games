package com.games.LeetCode.DecChallenge.SubtreeWithDeepest;

public class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return lcaDeepestLeaves(root);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null)
            return null;
        int left = height(root.left);
        int right = height(root.right);
        if (left == right)
            return root;
        else if (left < right)
            return lcaDeepestLeaves(root.right);
        else
            return lcaDeepestLeaves(root.left);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
