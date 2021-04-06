package com.games.LeetCode.Contest.A;

public class Solution {

    public String max(String str) {
        int ones = 0;
        int zeros = 0;
        for (char ch : str.toCharArray())
            if (ch == '1') ones++;
            else zeros++;
        if (ones <= zeros) {
            ones++;
            zeros = 0;
        }
        return repeat("1", ones) + repeat("0", zeros);
    }

    private String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }

    public long mex(String str) {
        for (long i = 0; i < Long.parseLong(str); i++) {
            if (!isSubSequence(str, Long.toBinaryString(i)))
                return i;
        }
        return 1L;
    }

    private boolean isSubSequence(String str, String string) {
        int j = 0;
        for (int i = 0; i < str.length() && j < string.length(); i++)
            if (string.charAt(j) == str.charAt(i))
                j++;
        return (j == string.length());
    }
}
