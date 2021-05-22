package com.games.CodeForces.kingEscape;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ax = sc.nextInt() - 1, ay = sc.nextInt() - 1;
        int bx = sc.nextInt() - 1, by = sc.nextInt() - 1;
        int cx = sc.nextInt() - 1, cy = sc.nextInt() - 1;
        if ((cx - ax) * (ax - bx) > 0 || (cy - ay) * (ay - by) > 0) System.out.println("NO");
        else System.out.println("YES");
    }
}
