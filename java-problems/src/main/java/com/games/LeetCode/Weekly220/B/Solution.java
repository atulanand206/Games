package com.games.LeetCode.Weekly220.B;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int startIndex = 0;
        int endIndex = 0;
        int maxSum = nums[startIndex] + nums[endIndex];
        Set<Integer> set = new HashSet<>();
        set.add(nums[startIndex]);
        while (startIndex != nums.length - 1 && endIndex != nums.length - 1) {
            while (endIndex < nums.length - 1 && !set.contains(nums[endIndex + 1])) {
                set.add(nums[++endIndex]);
            }
            int sum = sum(set);
            if (sum > maxSum) {
                maxSum = sum;
            }
            boolean removed = false;
            while (startIndex <= nums.length - 1 && startIndex <= endIndex && set.contains(nums[startIndex])) {
                set.remove(nums[startIndex++]);
                removed = true;
            }
            if (!removed) {
                set.remove(nums[startIndex++]);
            }
        }
        return maxSum;
    }

    private int sum(Set<Integer> set) {
        int sum = 0;
        for (int i : set) {
            System.out.printf("%d ", i);
            sum += i;
        }
        System.out.println();
        return sum;
    }
}
