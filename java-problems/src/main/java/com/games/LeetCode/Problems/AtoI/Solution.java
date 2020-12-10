package com.games.LeetCode.Problems.AtoI;

public class Solution {

    public int myAtoi(String s) {
        s = s.trim();
        int indx = 0;
        if (s.length() == 0)
            return 0;
        StringBuilder num = new StringBuilder();
        while (indx < s.length() && (s.charAt(indx) == '-' || s.charAt(indx) == '+'))
            num.append(s.charAt(indx++));
        while (indx < s.length() && (Character.isDigit(s.charAt(indx))))
            num.append(s.charAt(indx++));
        if (num.length() == 0)
            return 0;
        int spclChars = 0;
        for (int i =0; i<num.length();i++)
            if (num.charAt(i) == '-' || num.charAt(i) == '+')
                spclChars++;
        if (spclChars > 1 || spclChars == num.length())
            return 0;
        boolean isNeg = false;
        if (s.charAt(0) == '-')
            isNeg = true;
        String numberToConvert = num.toString();
        try {
            return Integer.parseInt(numberToConvert);
        } catch (Exception e) {
            return (isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE);
        }
    }
}
