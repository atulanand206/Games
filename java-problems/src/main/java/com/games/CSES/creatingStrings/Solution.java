package com.games.CSES.creatingStrings;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    Set<String> words = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String s = sc.nextLine();
        Solution solution = new Solution();
        solution.permute(s, 0, s.length() - 1);
        System.out.println(solution.words.size());
        print(solution.words);
    }

    private void permute(String str, int l, int r) {
        if (l == r)
            words.add(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static <T> void print(Set<T> list) {
        for (T in : list)
            System.out.println(in);
    }
}
