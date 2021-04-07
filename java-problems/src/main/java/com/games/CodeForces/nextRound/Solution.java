package com.games.CodeForces.nextRound;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner br = new Scanner(new InputStreamReader(System.in));
        int n = br.nextInt();
        int k = br.nextInt();
        int count = 0;
        int s = 0;
        while (k-- > 0) {
            s = br.nextInt();
            if (s > 0)
                count++;
            n--;
        }
        while (n-- > 0 && br.nextInt() == s)
            if (s > 0)
                count++;
        System.out.println(count);
    }
}
