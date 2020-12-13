package com.games.LeetCode.Problems.SymmetricTree;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        return t1 == null && t2 == null || t1 != null && t2 != null && (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
