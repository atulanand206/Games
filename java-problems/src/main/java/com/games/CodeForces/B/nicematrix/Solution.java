package com.games.CodeForces.B.nicematrix;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Problem: CF 486B
 *
 * @author atulanand
 */

public class Solution {

    static class Point {
        int x;
        int y;

        static Point of(int x, int y) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            return p;
        }

        int in(int[][] matrix) {
            return matrix[x][y];
        }

        void right() {
            y++;
        }

        void left() {
            y--;
        }

        void up() {
            x--;
        }

        void down() {
            x++;
        }
    }

    static class Result {

        int cnt = 0;

        public String solve(int[][] arr) {
            O.debug(S.string(arr));
            checkRows(arr);
            O.debug(S.string(cnt));
            return "NO";
        }

        private void checkRows(int[][] arr) {
            int rows = arr.length;
            int cols = arr[0].length;
            for (int i = 0; i < rows / 2 + 1; i++) {
                Point TLR = Point.of(i, 0);
                Point BLR = Point.of(rows - 1 - i, 0);
                Point TRL = Point.of(i, cols - 1);
                Point BRL = Point.of(rows - 1 - i, cols - 1);
                for (int j = 0; j < cols / 2; j++) {
                    checkPalindrome(arr, TLR.x, TLR.y, TRL.x, TRL.y, BLR.x, BLR.y, BRL.x, BRL.y);
                    TRL.left();
                    TLR.right();
                    BRL.left();
                    BLR.right();
                }
            }
            for (int i = 0; i <= cols / 2 + 1; i++) {
                Point TLD = Point.of( 0, i);
                Point BLU = Point.of(rows - 1, i);
                Point TRD = Point.of(0, cols - 1 - i);
                Point BRU = Point.of(rows - 1, cols - 1 - i);
                for (int j = 0; j < rows / 2; j++) {
                    checkPalindrome(arr, TLD.x, TLD.y, TRD.x, TRD.y, BLU.x, BLU.y, BRU.x, BRU.y);
                    TRD.down();
                    TLD.down();
                    BRU.up();
                    BLU.up();
                }
            }
        }

        private void checkPalindrome(int[][] arr, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
            O.debug(S.string(x1 + " " + y1 + " " + x2 + " " + y2));
            O.debug(S.string(x3 + " " + y3 + " " + x4 + " " + y4));
            if (y1 <= y2 && x1 <= x3 && (x1 != x3 || y1 != y2)) {
                if (x3 < 0 || x1 == x3) {
                    if (arr[x1][y1] != arr[x2][y2]) {
                        cnt++;
                    }
                } else if (y2 < 0 || y1 == y2) {
                    if (arr[x1][y1] != arr[x3][y3]) {
                        cnt++;
                    }
                } else {
                    Map<Integer, Integer> map = new HashMap<>();
                    map.merge(arr[x1][y1], 1, Integer::sum);
                    map.merge(arr[x2][y2], 1, Integer::sum);
                    map.merge(arr[x3][y3], 1, Integer::sum);
                    map.merge(arr[x4][y4], 1, Integer::sum);
                    Optional<Integer> max = map.values().stream().max(Comparator.naturalOrder());
                    max.ifPresent(maxCount -> cnt += 4 - maxCount);
                }
            }
            O.debugNewLine();
        }

    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
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
