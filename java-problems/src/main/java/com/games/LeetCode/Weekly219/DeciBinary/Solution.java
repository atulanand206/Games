package com.games.LeetCode.Weekly219.DeciBinary;

public class Solution {

    public int minPartitions(String n) {
        int max = 0;
        for (char ch : n.toCharArray())
            max = Math.max(Integer.parseInt(String.valueOf(ch)), max);
        return max;
    }
}
