package com.games.CF.START3C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hiringTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int n = Integer.parseInt(spec[0]), m = Integer.parseInt(spec[1]);
            String[] spec2 = br.readLine().split(" ");
            int x = Integer.parseInt(spec2[0]), y = Integer.parseInt(spec2[1]);
            for (int i = 0; i < n; i++) {
                String ss = br.readLine();
                int f = 0, u = 0, p = 0;
                for (char ch : ss.toCharArray())
                    if (ch == 'F') f++;
                    else if (ch == 'U') u++;
                    else if (ch == 'P') p++;
                if (f >= x || (f == (x - 1) && p >= y)) System.out.print("1");
                else System.out.print("0");
            }
            System.out.println();
        }
    }
}
