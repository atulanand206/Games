package com.games.CodeForces.beautifulMatrix;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int x = 0, y = 0;
        while (x++ != 5) {
            String s = sc.nextLine();
            if (s.contains("1")) {
                String[] split = s.split(" ");
                while (!split[y++].equals("1") && y != 5) {
                }
                break;
            }
        }
        System.out.println(Math.abs(x - 3) + Math.abs(y - 3));
    }
}