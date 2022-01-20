package com.games.CodeForces.A.keyboard;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 474A
 *
 * @author atulanand
 */
public class Solution {

    private static char[][] keyboard = new char[][] {
        "qwertyuiop".toCharArray(),
        "asdfghjkl;".toCharArray(),
        "zxcvbnm,./".toCharArray()
    };

    public static String solve(char side, char[] A) {
        StringBuilder sb = new StringBuilder();
        int change = side == 'R' ? -1 : 1;
        for (char ch : A) sb.append(res(ch, change));
        return sb.toString();
    }

    private static char res(char c, int x) {
        for (char[] chars : keyboard) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c)
                    return chars[j + x];
            }
        }
        return ' ';
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char side = br.readLine().trim().toCharArray()[0];
            sb.append(solve(side, br.readLine().trim().toCharArray())).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split("");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
