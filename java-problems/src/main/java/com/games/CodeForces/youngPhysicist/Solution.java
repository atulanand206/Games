package com.games.CodeForces.youngPhysicist;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        int x = 0, y = 0, z = 0;
        while (t-- > 0) {
            x += sc.nextInt();
            y += sc.nextInt();
            z += sc.nextInt();
        }
        System.out.println((x == 0 && y == 0 && z == 0) ? "YES" : "NO");
    }
}
