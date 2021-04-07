package com.games.CodeForces.wayTooLongWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String word = br.readLine().trim();
            if (word.length() <= 10)
                System.out.println(word);
            else
                System.out.printf("%s%d%s\n", word.charAt(0), word.length() - 2, word.charAt(word.length() - 1));
        }
    }
}
