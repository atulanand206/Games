package com.games.CF.START3C;

import java.io.InputStreamReader;
import java.util.Scanner;

public class chefAndIsland {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt(), xr = sc.nextInt(), yr = sc.nextInt(), D = sc.nextInt();
            boolean pos = y / yr >= D && x / xr >= D;
            System.out.println(pos ? "YES" : "NO");
        }
    }
}
