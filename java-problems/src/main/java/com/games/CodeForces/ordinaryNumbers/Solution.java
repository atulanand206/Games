package com.games.CodeForces.ordinaryNumbers;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String num = String.valueOf(n);
            int max = 9 * (num.length());
            int lead = Integer.parseInt(String.valueOf(num.charAt(0)));
            int brk = Integer.parseInt(new String(new char[num.length()]).replace("\0", String.valueOf(lead)));
            if (n < brk) max -= (10-lead);
            else max -= (9-lead);
            System.out.println(max);
        }
    }
}
/*
    111 - 9 * 3 - (9 - (1 - 0))
    110 - 9 * 3 - (9 - (1 - 1))
    112 - 9 * 3 - (9 - (1 - 0))
 */