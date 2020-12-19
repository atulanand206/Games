package com.games.LeetCode.Problems.IntegerToRoman;

public class Solution {

    private int num;
    private StringBuilder text;

    public String intToRoman(int nums) {
        num = nums;
        text = new StringBuilder();
        while (num >= 1000) {
            text.append("M");
            num -= 1000;
        }
        extractRoman(100, "C", "M", "D");
        extractRoman(10, "X", "C", "L");
        extractRoman(1, "I", "X", "V");
        return text.toString();
    }

    private void extractRoman(int intValue, String romanValue, String previousValue, String midValue) {
        int count = 0;
        while (num >= intValue) {
            count++;
            num -= intValue;
        }
        if (count == 9) {
            text.append(romanValue).append(previousValue);
        } else if (count == 4) {
            text.append(romanValue).append(midValue);
        } else if (count == 5) {
            text.append(midValue);
        } else if (count > 5 && count <= 8) {
            text.append(midValue);
            for (int i = 5; i < count; i++)
                text.append(romanValue);
        } else {
            for (int i = 0; i < count; i++)
                text.append(romanValue);
        }
    }
}
