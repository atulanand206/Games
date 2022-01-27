package com.games.CodeForces.div2.r768.B;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1631B
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] A) {
        if (A.length == 1) return 0;
        int cnt = 0;
        int i = A.length - 1;
        int j = i;
        while (j >= 0 && A[j] == A[i]) j--;
        int k = 0;
        while (k <= i && A[k] == A[i]) k++;
        if (j >= 0) {
            int x = i - j;
            int it = (1 << (cntBits(x) - 1));
            O.debug(S.string(x));
            O.debug(S.string(it));
            int toEat = j + 1;
            int z = toEat - k;
            if ((z & (z + 1)) == 0)
                toEat -= k;
            while (toEat > 0) {
                O.debug(S.string(toEat));
                cnt++;
                toEat-=it;
                it *= 2;
            }
        }
        O.debugNewLine();
        return cnt;
    }

    private static int cntBits(int x) {
        int cnt = 0;
        while (x > 0) {
            cnt++;
            x >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            int[] y = inputIntArray(br);
            sb.append(solve(y)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
