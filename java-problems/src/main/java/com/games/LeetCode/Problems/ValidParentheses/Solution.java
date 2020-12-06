package com.games.LeetCode.Problems.ValidParentheses;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(String.valueOf(c));
            else {
                if (isCloser(stack, c, ')', "(")
                        || isCloser(stack, c, '}', "{")
                        || isCloser(stack, c, ']', "["))
                    stack.pop();
                else
                    stack.push(String.valueOf(c));
            }
        }
        return stack.empty();
    }

    private boolean isCloser(Stack<String> stack, char c, char end, String start) {
        return !stack.empty() && c == end && stack.peek().equals(start);
    }
}
