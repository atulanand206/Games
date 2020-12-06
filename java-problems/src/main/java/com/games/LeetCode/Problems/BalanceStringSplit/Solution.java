package com.games.LeetCode.Problems.BalanceStringSplit;

public class Solution {

    public int balancedStringSplit(String s) {
        int b = 0;
        int balancedString = 0;
        char startChar = s.charAt(0);
        char endChar = startChar == 'L' ? 'R' : 'L';
        for (char c : s.toCharArray()) {
            if (c == startChar)
                b++;
            else if (c == endChar)
                b--;
            if (b == 0)
                balancedString++;
        }
        return balancedString;
    }
}
