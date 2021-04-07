package com.games.CodeForces.capsLock;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String str = new Scanner(new InputStreamReader(System.in)).nextLine();
        int count = 0;
        char ch = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                sb.append(Character.toLowerCase(str.charAt(i)));
                count++;
            } else {
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        if (count == str.length() - 1 && Character.isUpperCase(ch)) {
            sb.insert(0, Character.toLowerCase(ch));
            System.out.println(sb);
        } else if (count == str.length() - 1 && !Character.isUpperCase(ch)) {
            sb.insert(0, Character.toUpperCase(ch));
            System.out.println(sb);
        } else {
            System.out.println(str);
        }
    }
}
