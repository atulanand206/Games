package com.games.LeetCode.Problems.ReverseWords;

/**
 * Solution to LeetCode Problem #151. Reverse Words in a String
 * <p>
 * The string is split at all the spaces and built in the reverse manner using string builder.
 *
 * @author Atul Anand
 * @version 1.0 - 17th Dec 2020
 */
public class Solution {

    public String reverseWords(String s) {
        String[] split = s.trim().split("[ ]+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--)
            sb.append(split[i]).append(" ");
        return sb.toString().trim();
    }
}
