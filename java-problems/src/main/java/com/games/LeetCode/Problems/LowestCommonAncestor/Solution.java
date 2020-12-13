package com.games.LeetCode.Problems.LowestCommonAncestor;

public class Solution {

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

    public TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            if (arr[i] == null)
                return root;
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }
}
