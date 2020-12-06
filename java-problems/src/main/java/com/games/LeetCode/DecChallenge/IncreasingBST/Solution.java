package com.games.LeetCode.DecChallenge.IncreasingBST;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = root;
        TreeNode node = root;
        if (node.left == null) {
            newRoot.right = increasingBST(node);
        } else {

        }
        return newRoot;
    }
}
