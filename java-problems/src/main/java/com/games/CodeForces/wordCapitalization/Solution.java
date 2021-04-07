package com.games.CodeForces.wordCapitalization;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String s = new Scanner(new InputStreamReader(System.in)).nextLine();
        if (s.length() > 0)
            s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
        System.out.println(s);
    }
}
