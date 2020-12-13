package com.games.LeetCode.Problems.SingleNumberII;

public class Solution {

    public int singleNumber(int[] nums) {
        int seen_once = 0, seen_twice = 0;
        for (int num : nums) {
            System.out.println(seen_once ^ num);
            seen_once = ~seen_twice & (seen_once ^ num);
            System.out.println(seen_twice ^ num);
            seen_twice = ~seen_once & (seen_twice ^ num);
            System.out.println(seen_once + " : " + seen_twice);
        }
        return seen_once;
    }
}
