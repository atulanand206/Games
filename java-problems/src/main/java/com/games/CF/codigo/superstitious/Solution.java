package com.games.CF.codigo.superstitious;

import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static Set<String> words = new TreeSet<>();
    static int x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String s = sc.nextLine();
        x = sc.nextInt();
        permute(s, "");
        List<String> y = new ArrayList<>(words);
        System.out.println(y.get(x - 1));
    }

    static void permute(String s, String answer) {
        if (s.length() == 0) {
            if (sameNotConsecutive(answer))
                words.add(answer);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }

    private static void permute(String str, int l, int r) {
        if (l == r) {
            if (sameNotConsecutive(str))
                words.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private static boolean sameNotConsecutive(String str) {
        char[] cah = str.toCharArray();
        for (int i = 1; i < cah.length; i++) {
            if (cah[i] == cah[i - 1]) return false;
        }
        return true;
    }
}
