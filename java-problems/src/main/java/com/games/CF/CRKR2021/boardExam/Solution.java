package com.games.CF.CRKR2021.boardExam;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            System.out.println(nCr(n, x).multiply(nCr(n, y)));
        }
    }

    private static BigInteger nCr(int n, int x) {
        return fact(n).divide(fact(x)).divide(fact(n - x));
    }

    private static BigInteger fact(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= n; i++) res = res.multiply(BigInteger.valueOf(i));
        return res;
    }
}
