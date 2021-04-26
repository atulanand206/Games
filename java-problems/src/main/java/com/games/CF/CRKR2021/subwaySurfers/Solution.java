package com.games.CF.CRKR2021.subwaySurfers;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int T = sc.nextInt();
        while (T-- > 0) {
            int r = sc.nextInt(), n = sc.nextInt(), t = sc.nextInt();
            int c  = 0;
            while (n-- > 0){
                if (t >= 2) {
                    c += sc.nextInt();
                    t -= 2;
                } else if (t == 1) {
                    c += sc.nextInt() / 2;
                    t--;
                } else sc.nextInt();
            }
            System.out.println(r <= c ? "YES" : "NO");
        }
    }
}
