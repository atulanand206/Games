package com.games.LeetCode.Problems.GenerateParentheses;

import java.util.*;

public class Solution {

    public List<String> generateParenthesis(int n) {
        String str = new String(new char[n]).replace("\0", "(") + new String(new char[n]).replace("\0", ")");
        Set<String> strings = permutationFinder(str);
        Set<String> set = new TreeSet<>();
        for (String string : strings)
            if (isValidParentheses(string))
                set.add(string);
        return new ArrayList<>(set);
    }

    private static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    private static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                if (stack.empty())
                    return false;
                if (stack.peek() == '(')
                    stack.pop();
                else if (stack.peek() == ')')
                    stack.push(ch);
            }
        }
        return stack.empty();
    }
}
