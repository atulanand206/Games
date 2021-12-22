package com.games.CodeForces.comlexmarketanalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: CodeForces 1609C
 *
 * @author atulanand
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        primeNumbers = primes((int) 1E6);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] q = inputIntArray(br);
            int n = q[0], e = q[1], ans = 0;
            int[] arr = inputIntArray(br);
            int height = (int) Math.ceil((float) arr.length / e);
            int[][] matrix = asMatrix(e, arr, height);
            boolean[][] asOnes = isOnes(matrix);
            boolean[][] asPrimes = isPrimes(matrix);
            long res = 0;
            for (int i = 0; i < e; i++)
                res += column(matrix, asOnes, asPrimes, i);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static long column(int[][] matrix, boolean[][] ones, boolean[][] primes, int idx) {
        long res = 0;
        int k = matrix.length;
        if (matrix[matrix.length - 1][idx] == 0) k--;
        for (int i = 0; i < k; i++) {
            if (primes[i][idx]) {
                int onesBefore = 0, j = i - 1;
                while (j >= 0 && ones[j][idx]) {
                    onesBefore++;
                    j--;
                }
                int onesAfter = 0; j = i + 1;
                while (j < k && ones[j][idx]) {
                    onesAfter++;
                    j++;
                }
                res += onesBefore;
                res += onesAfter;
                if (onesBefore > 0 && onesAfter > 0)
                    res += onesAfter + onesBefore - 1;
            }
        }
        return res;
    }

    private static int[][] asMatrix(int e, int[] arr, int height) {
        int[][] matrix = new int[height][e];
        int k = 0;
        for (int i = 0; i < matrix.length && k < arr.length; i++)
            for (int j = 0; j < e && k < arr.length; j++)
                matrix[i][j] = arr[k++];
        return matrix;
    }

    private static Set<Integer> primeNumbers = new HashSet<>();

    public static Set<Integer> primes(int n) {
        Set<Integer> primes = new HashSet<>();
        int[] largestPrime = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (largestPrime[i] != 0) continue;
            primes.add(i);
            for (int j = 2 * i; j <= n; j += i) largestPrime[j] = i;
        }
        return primes;
    }

    private static boolean[][] isPrimes(int[][] matrix) {
        boolean[][] res = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                res[i][j] = primeNumbers.contains(matrix[i][j]);
        return res;
    }

    private static boolean[][] isOnes(int[][] matrix) {
        boolean[][] res = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                res[i][j] = matrix[i][j] == 1;
        return res;
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
