package com.games.CF.May21C.ticTacToe;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            char[] board = new char[9];
            char[] row = inputCharArray(br);
            int i = 0;
            for (char ch : row) board[i++] = ch;
            row = inputCharArray(br);
            for (char ch : row) board[i++] = ch;
            row = inputCharArray(br);
            for (char ch : row) board[i++] = ch;
            isOver(board);
        }
    }

    private static final int[][] win = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    private static boolean isWinner(char[] board, char c) {
        for (int i = 0; i < 8; i++) {
            if (board[win[i][0]] == c
                    && board[win[i][1]] == c
                    && board[win[i][2]] == c) {
                return true;
            }
        }
        return false;
    }

    private static void isOver(char[] board) {
        int cx = countChar(board, 'X');
        int co = countChar(board, 'O');
        if (cx - co != 0 && cx - co != 1) {
            System.out.println(3);
            return;
        }
        if (isWinner(board, 'O')) {
            if (isWinner(board, 'X')) {
                System.out.println(3);
                return;
            }
            if (cx == co) {
                System.out.println(1);
            } else {
                System.out.println(3);
            }
            return;
        }
        if (isWinner(board, 'X')) {
            if (cx == co) {
                System.out.println(3);
                return;
            }
            System.out.println(1);
            return;
        }
        int empty = countChar(board, '_');
        System.out.println(empty == 0 ? 1 : 2);
    }

    private static int countChar(char[] board, char x) {
        int cnt = 0;
        for (char ch : board) if (ch == x) cnt++;
        return cnt;
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static char[] inputCharArray(BufferedReader br) throws IOException {
        return br.readLine().toCharArray();
    }
}
