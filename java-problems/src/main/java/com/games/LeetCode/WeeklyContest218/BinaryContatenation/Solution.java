package com.games.LeetCode.WeeklyContest218.BinaryContatenation;

public class Solution {

    public int concatenatedBinary(int n) {
        long a = 1;
        if (n == 1)
            return 1;
        int digits = 1;
        int lastFactor = 1;
        for (int i = 2; i <= n; i++) {
            if (i % lastFactor == 0) {
                digits++;
                lastFactor = i;
            }
            int i1 = 1000000007;
            a = (a << digits) % i1;
            a = (a + i) % i1;
        }
        return (int) a;
    }
}
