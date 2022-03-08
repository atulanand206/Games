package com.games.CodeForces.B.orinmatrix;

import com.games.utils.I;
import com.games.utils.O;

import java.io.*;

/**
 * Problem: CF 486B
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        public String solve(int[][] arr) {
            int[] elemInRows = new int[arr.length];
            int[] elemInCols = new int[arr[0].length];
            if (!elements(arr, elemInRows, elemInCols)) {
                return stringify(arr);
            }
            if (isPossible(arr, elemInRows, elemInCols)) {
                int[][] matrix = crossHairs(arr, elemInRows, elemInCols);
                int[][] filled = crossBars(matrix);
                if (isMatch(arr, filled)) {
                    return stringify(matrix);
                }
            }
            return "NO";
        }

        private boolean elements(int[][] arr, int[] elemInRows, int[] elemInCols) {
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 1) {
                        elemInCols[j]++;
                        elemInRows[i]++;
                        flag = true;
                    }
                }
            }
            return flag;
        }

        private int[][] crossBars(int[][] a) {
            int[][] res = new int[a.length][a[0].length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] == 1) {
                        for (int k = 0; k < a.length; k++) {
                            res[k][j] = 1;
                        }
                        for (int k = 0; k < a[0].length; k++) {
                            res[i][k] = 1;
                        }
                    }
                }
            }
            return res;
        }

        private int[][] crossHairs(int[][] a, int[] elemInRows, int[] elemInCols) {
            int[][] matrix = new int[a.length][a[0].length];
            for (int i = 0; i < elemInRows.length; i++) {
                if (elemInRows[i] == 0) {
                    continue;
                }
                for (int j = 0; j < elemInCols.length; j++) {
                    if (elemInCols[j] == 0) {
                        continue;
                    }
                    matrix[i][j] = 1;
                }
            }
            return matrix;
        }

        private boolean isPossible(int[][] a, int[] elemInRows, int[] elemInCols) {
            boolean rowPossible = false;
            boolean colPossible = false;
            for (int i = 0; i < elemInRows.length; i++) {
                elemInRows[i] = elemInRows[i] == a[0].length ? 1 : 0;
                rowPossible |= elemInRows[i] == 1;
            }
            for (int i = 0; i < elemInCols.length; i++) {
                elemInCols[i] = elemInCols[i] == a.length ? 1 : 0;
                colPossible |= elemInCols[i] == 1;
            }
            return rowPossible && colPossible;
        }

        private boolean isMatch(int[][] matrix, int[][] f) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != f[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        private String stringify(int[][] matrix) {
            StringBuilder sb = new StringBuilder();
            sb.append("YES\n");
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    sb.append(anInt).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] ints = inputIntArray(br);
            int[][] matrix = new int[ints[0]][];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = inputIntArray(br);
            }
            sb.append(new Result().solve(matrix)).append("\n");
        }
        System.out.println(sb);
    }

    private static char[] inputCharArray(BufferedReader br) throws IOException {
        return br.readLine().trim().toCharArray();
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
