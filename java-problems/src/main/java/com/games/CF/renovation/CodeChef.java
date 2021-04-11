package com.games.CF.renovation;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int w = sc.nextInt(), h = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt(), c = sc.nextInt();
        int hTs;
        int tC = 0;
        if (w % a != 0) {
            hTs = (w + a) / a;
            tC += w * c;
        } else {
            hTs = w / a;
        }
        int vTs;
        if (h % b != 0) {
            vTs = (h + b) / b;
            tC += h * c;
        } else {
            vTs = h / b;
        }
        int tTs = hTs * vTs;
        int tPs = (tTs + 10) / 10;
        tC += tPs * m;
        System.out.println(tC);
    }
}
