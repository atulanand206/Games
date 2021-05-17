package com.games.CF.LRNDSA06.chefAndWeirdQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> pre = perfectSquares();
        int t = inputInt(br);
        while (t-- > 0) {
            long y = inputLong(br);
            long count = 0;
            for (Long aPre : pre)
                if (y > aPre) count += Math.min(y - aPre, 700);
                else break;
            System.out.println(count);
        }
    }

    private static List<Long> perfectSquares() {
        List<Long> arr = new ArrayList<>();
        for (int i = 1; i < Math.pow(10, 5); i++) arr.add((long) (i * i));
        return arr;
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }
}
