package com.games.LeetCode.Problems.ReverseInt;

public class Solution {

    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
        }
        String s = String.valueOf(x);
        String result = "";
        if (isNeg) {
            result += "-";
            s = s.substring(1, s.length());
        }
        result += new StringBuffer(s).reverse();
        try {
            return Integer.parseInt(result);
        } catch(Exception e) {
            return 0;
        }
    }
}
