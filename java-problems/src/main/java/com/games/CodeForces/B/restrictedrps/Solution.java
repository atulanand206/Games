package com.games.CodeForces.B.restrictedrps;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1245B
 *
 * @author atulanand
 */
public class Solution {

    int P, R, S;
    int wins = 0;
    char[] tally;

    public String solve(int[] A, String B) {
        P = A[1]; R = A[0]; S = A[2];
        wins = 0;
        winningTally(B);
        losingTally();
        int k = R + P + S;
        int minWins = (int) Math.ceil(B.length() / (double) 2);
        String s = tallyString();
        O.debug(s + " " + wins + " " + minWins + "\n");
        return wins >= minWins ? "YES\n" + s : "NO";
    }

    private String tallyString() {
        StringBuilder conf = new StringBuilder();
        for (char ch : tally) {
            conf.append(ch);
        }
        return  conf.toString();
    }

    private void losingTally() {
        for (int i = 0; i < tally.length; i++) {
            if (tally[i] == ' ') {
                if (R > 0) {
                    R--;
                    tally[i] = 'R';
                } else if (P > 0) {
                    P--;
                    tally[i] = 'P';
                } else {
                    S--;
                    tally[i] = 'S';
                }
            }
        }
    }

    private void winningTally(String B) {
        tally = new char[B.length()];
        Arrays.fill(tally, ' ');
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (ch == 'R') {
                if (P > 0) {
                    P--;
                    wins++;
                    tally[i] = 'P';
                }
            } else if (ch == 'P') {
                if (S > 0) {
                    S--;
                    wins++;
                    tally[i] = 'S';
                }
            } else if (ch == 'S') {
                if (R > 0) {
                    R--;
                    wins++;
                    tally[i] = 'R';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
            sb.append(new Solution().solve(inputIntArray(br), br.readLine())).append("\n");
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
