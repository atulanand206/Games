package com.games.CodeForces.chatRoom;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isSubSequence(new Scanner(new InputStreamReader(System.in)).nextLine(), "hello") ? "YES" : "NO");
    }

    private static boolean isSubSequence(String str, String string) {
        int j = 0;
        for (int i = 0; i < str.length() && j < string.length(); i++) if (string.charAt(j) == str.charAt(i)) j++;
        return (j == string.length());
    }
}
