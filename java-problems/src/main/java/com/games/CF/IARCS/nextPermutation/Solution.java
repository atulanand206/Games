package com.games.CF.IARCS.nextPermutation;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), k = sc.nextInt();
        while (k-- > 0) {
            Integer[] ar = new Integer[n];
            for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
            Integer[] np = nextPermutation(ar);
            for (int i : np) System.out.printf("%d ", i);
            System.out.println();
        }
    }

    private static Integer[] nextPermutation(Integer[] ar) {
        Integer[] a = ar;
        Arrays.sort(a, Collections.reverseOrder());
        int compare = Arrays.compare(ar, a);
        System.out.println(compare);
        return new Integer[0];
    }
}
