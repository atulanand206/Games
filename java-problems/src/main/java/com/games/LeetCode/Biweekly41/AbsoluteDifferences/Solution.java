package com.games.LeetCode.Biweekly41.AbsoluteDifferences;

public class Solution {
//    public int[] getSumAbsoluteDifferences(int[] nums) {
//        int[] result = new int[nums.length];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums)
//            map.merge(i, 1, Integer::sum);
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                if (entry.getKey() != nums[i]) {
//                    sum += entry.getValue() * Math.abs(nums[i] - entry.getKey());
//                }
//            }
//            result[i] = sum;
//        }
//        return result;
//    }

    public int[] getSumAbsoluteDifferences(int[] arr) {
        // Length of the array
        int n = arr.length;
        int sub = 0;
        int sum = 0;

        // Initialize the arraylist
        int[] result = new int[arr.length];

        // Keep track of the accumulated
        // of the sum of values to right
        for (int i = n - 1; i >= 0; i--)
            sum += arr[i];

        // Keep track of the accumulated
        // subtraction of the values to the left
        for (int i = 0; i < arr.length; i++) {

            sum -= arr[i];

            // Add the value to the resultant
            // array ans[]
            result[i] = (sub + (i * arr[i]) - ((n - i - 1) * arr[i]) + sum);

            sub -= arr[i];
        }
        // return the final answer
        return result;
    }
}
