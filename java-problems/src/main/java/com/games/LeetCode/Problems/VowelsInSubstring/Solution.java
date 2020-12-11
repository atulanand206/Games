package com.games.LeetCode.Problems.VowelsInSubstring;

import java.util.Set;

public class Solution {

    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int vowelsInWindow = 0;
        for (int i = 0; i < k && i < s.length(); i++)
            if (isVowel(s.charAt(i)))
                vowelsInWindow++;
        int maxVowels = vowelsInWindow;
        for (int i = 1; i <= s.length() - k; i++) {
            if (isVowel(s.charAt(i - 1)))
                vowelsInWindow--;
            if (isVowel(s.charAt(i + k - 1)))
                vowelsInWindow++;
            maxVowels = Math.max(vowelsInWindow, maxVowels);
        }
        return maxVowels;
    }

    public boolean isVowel(char ch) {
        return vowels.contains(ch);
    }
}
