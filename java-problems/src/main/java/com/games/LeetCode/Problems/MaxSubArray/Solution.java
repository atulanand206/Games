package com.games.LeetCode.Problems.MaxSubArray;

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int length = 0;
        int startIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = length - 1; i < nums.length - 1; i++) {
            int sum = 0;
            for (int j = startIndex; j <= startIndex + length && j < nums.length; j++) {
                sum += nums[j];
            }
            System.out.println(startIndex + " : " + (startIndex + length) + " : " + sum);
            maxSum = Math.max(sum, maxSum);
            for (int k = startIndex; k < nums.length - length && startIndex + length < nums.length - 1; k++) {
                sum -= nums[startIndex];
                startIndex++;
                sum += nums[(startIndex + length)];
                System.out.println(startIndex + " : " + (startIndex + length) + " : " + sum);
                maxSum = Math.max(sum, maxSum);
            }
            startIndex = 0;
            length++;
        }
        return maxSum;
    }

    public int maxSubArraySum(int a[]) {
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int anA : a) {
            max_ending_here = max_ending_here + anA;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
