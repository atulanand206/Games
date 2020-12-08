package com.games.CodeForces.avoidTrygub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final String TRYGUB = "trygub";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            String a = br.readLine();
            System.out.println(reordered(a));
        }
    }

    public static String reordered(String input) {
        if (isSubSequence(input)) {
            int[] count = new int[]{0, 0, 0, 0, 0, 0};
            List<Character> otherCharacters = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (TRYGUB.contains(String.valueOf(ch))) {
                    int index = TRYGUB.indexOf(ch);
                    count[index]++;
                } else {
                    otherCharacters.add(ch);
                }
            }
            return joinString(count, otherCharacters);
        }
        return input;
    }

    public static String joinString(int[] count, List<Character> otherCharacters) {
        StringBuilder sb = new StringBuilder();
        for (int i = TRYGUB.length() - 1; i > -1; i--) {
            char ch = TRYGUB.charAt(i);
            for (int j = 0; j < count[i]; j++) {
                sb.append(ch);
            }
        }
        for (Character ch : otherCharacters)
            sb.append(ch);
        return sb.toString();
    }

    public static boolean isSubSequence(String input) {
        return isSubSequence(TRYGUB, input, TRYGUB.length(), input.length());
    }

    private static boolean isSubSequence(String str1, String str2, int m, int n) {
        int j = 0;
        for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;
        return (j == m);
    }
}
