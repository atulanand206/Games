package com.games.CodeChef.jan221b.primeinbinarystring;

import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Problem: CodeChef Long Challenge
 *
 * @author atulanand
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        O.attach();
//        BufferedReader br = new BufferedReader(I.reader(true));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(br.readLine()) ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean solve(String br) throws IOException {
        if (br.equals("1")) return false;
        return !Arrays.stream(br.substring(0, br.length() - 1).split("")).allMatch(s -> s.equals("0"));
    }
}
