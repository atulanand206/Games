package com.games.UVa.P146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("#")) {
            System.out.println(nextString(line));
        }
    }

    public static String nextString(String line) {
        for (int i = line.length() - 1; i > -1; i--) {
            char charAt = line.charAt(i);
            String substring = line.substring(i + 1, line.length());
            if (successorAvailable(charAt, substring)) {
                char c = chooseCharacter(charAt, substring);
                int indx = substring.indexOf(c);
                return line.substring(0, i) + c + sorted(remainingCharacters(charAt, substring, indx));
            }
        }
        return "No Successor";
    }

    private static String remainingCharacters(char charAt, String substring, int indx) {
        return charAt + substring.substring(0, indx) + substring.substring(indx + 1, substring.length());
    }

    public static String sorted(String characters) {
        char[] a = characters.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static char chooseCharacter(char charAt, String substring) {
        for (char ch : sorted(substring).toCharArray())
            if (ch > charAt)
                return ch;
        return charAt;
    }

    public static boolean successorAvailable(char c, String substring) {
        for (Character ch : substring.toCharArray())
            if (ch.compareTo(c) > 0)
                return true;
        return false;
    }
}