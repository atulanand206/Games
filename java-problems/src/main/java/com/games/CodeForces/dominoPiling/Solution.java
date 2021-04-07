package com.games.CodeForces.dominoPiling;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int m = s.nextInt();
        int n = s.nextInt();
        int sqm, sqn;
        if (m % 2 == 0) sqm = m;
        else sqm = m - 1;
        if (n % 2 == 0) sqn = n;
        else sqn = n - 1;
        int xm = m - sqm;
        int xn = n - sqn;
        int res = sqm * sqn / 2;
        int tilesInRow = n / 2;
        int tilesInCol = m / 2;
        res += tilesInCol * xn + tilesInRow * xm;
        if (m % 2 == 0 && n % 2 == 0 && xm == 1 && xn == 1)
            res -= 2;
        System.out.println(res);
    }
}
