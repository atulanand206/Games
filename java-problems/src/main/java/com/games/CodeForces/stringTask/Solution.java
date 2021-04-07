package com.games.CodeForces.stringTask;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String s = new Scanner(new InputStreamReader(System.in)).next();
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
        for (char ch : s.toCharArray())
            if (!vowels.contains(Character.toLowerCase(ch))) sb.append(".").append(Character.toLowerCase(ch));
        System.out.println(sb);
    }
}
