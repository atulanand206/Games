package com.games.LeetCode.Problems.SmallestGreaterThanTarget;

public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        for (char ch : letters) {
            if (ch > target)
                return ch;
        }
        for (char ch : letters) {
            if (ch + 26 > target)
                return ch;
        }
        return target;
    }
}
