package com.games.CodeForces.fillomino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = inputInt(br);
        int[] arr = inputIntArray(br);
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ints = new ArrayList<>();
            for (int j = 0; j < i; j++) ints.add(0);
            ints.add(arr[i]);
            matrix.add(ints);
        }
        for (int i = 0; i < n; i++) {
            int k = 1;
            int z = arr[i];
            int x = i, y = i;
            while (k < z) {
                if (y > 0 && matrix.get(x).get(y - 1) == 0) y--;
                else if (x < n - 1 && matrix.get(x + 1).get(y) == 0) x++;
                matrix.get(x).set(y, z);
                k++;
            }
        }
        print2D(matrix);
    }

    private static <T> void print2D(List<List<T>> list) {
        for (List<T> in : list)
            print(in);
        System.out.println();
    }

    private static <T> void print(List<T> list) {
        for (T in : list)
            System.out.print(in + " ");
        System.out.println();
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
