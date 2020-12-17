package com.games.LeetCode.Problems.ReformatString;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String reformat(String s) {
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        for (Character ch : s.toCharArray())
            if (Character.isDigit(ch))
                digits.add(ch);
            else if (Character.isAlphabetic(ch))
                letters.add(ch);
        if (Math.abs(digits.size() - letters.size()) <= 1) {
            StringBuilder sb = new StringBuilder();
            int i = 0, j = 0;
            boolean digit = digits.size() > letters.size();
            while (i != digits.size() || j != letters.size()) {
                if (digit)
                    sb.append(digits.get(i++));
                else
                    sb.append(letters.get(j++));
                digit = !digit;
            }
            return sb.toString();
        }
        return "";
    }
}
