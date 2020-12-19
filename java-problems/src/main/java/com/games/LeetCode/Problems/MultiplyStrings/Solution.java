package com.games.LeetCode.Problems.MultiplyStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.length() == 0)
            num1 = "0";
        if (num2.length() == 0)
            num2 = "0";
        int[] ints1 = intArray(num1);
        int[] ints2 = intArray(num2);
        List<Integer> result = new ArrayList<>();
        for (int i = ints2.length - 1; i > -1; i--) {
            List<Integer> multiply = multiply(ints1, ints2[i], ints2.length - i - 1);
            addLists(result, multiply);
        }
        int zeroes = 0;
        for (int i : result)
            if (i == 0)
                zeroes++;
        if (zeroes == result.size())
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i : result)
            sb.append(i);
        return sb.toString();
    }

    private void addLists(List<Integer> result, List<Integer> multiply) {
        int size = Math.max(result.size(), multiply.size());
        fixSize(result, size);
        fixSize(multiply, size);
        for (int i = 0; i < size; i++)
            result.set(i, result.get(i) + multiply.get(i));
        fixCarry(result);
    }

    private void fixSize(List<Integer> result, int size) {
        Collections.reverse(result);
        while (result.size() != size)
            result.add(0);
        Collections.reverse(result);
    }

    private List<Integer> multiply(int[] ints, int num, int initialZeroes) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < initialZeroes; i++)
            list.add(0);
        for (int i = ints.length - 1; i > -1; i--)
            list.add(ints[i] * num);
        Collections.reverse(list);
        fixCarry(list);
        return list;
    }

    private void fixCarry(List<Integer> list) {
        Collections.reverse(list);
        int carry = 0;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i) + carry;
            carry = val / 10;
            list.set(i, val % 10);
        }
        if (carry != 0)
            list.add(carry);
        Collections.reverse(list);
    }

    private int[] intArray(String num) {
        char[] chars = num.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++)
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        return ints;
    }
}
