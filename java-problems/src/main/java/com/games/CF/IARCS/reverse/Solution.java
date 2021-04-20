package com.games.CF.IARCS.reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        while (n-- > 0) strings.add(reverseString(br.readLine()));
        for (int i = strings.size() - 1; i >= 0; i--) System.out.println(strings.get(i));
    }

    private static String reverseString(String string) {
        String[] split = string.replaceAll("['.,;: ]+", " ").split(" ");
        StringBuilder op = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) op.append(split[i]).append(" ");
        return op.toString();
    }
}
