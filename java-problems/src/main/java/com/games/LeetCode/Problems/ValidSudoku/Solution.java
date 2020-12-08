package com.games.LeetCode.Problems.ValidSudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[][] topLeftVertices = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};

    public boolean isValidSudoku(char[][] board) {
        for (int[] topLeftVertex : topLeftVertices)
            if (!isBoxValid(board, topLeftVertex[0], topLeftVertex[1])) return false;
        for (int i = 0; i < 9; i++)
            if (!isRowValid(board, i)) return false;
        for (int i = 0; i < 9; i++)
            if (!isColumnValid(board, i)) return false;
        return true;
    }

    public boolean isColumnValid(char[][] board, int row) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            addCharacter(characters, board[i][row]);
        return validate(characters);
    }

    public boolean isRowValid(char[][] board, int row) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            addCharacter(characters, board[row][i]);
        return validate(characters);
    }

    public boolean isBoxValid(char[][] board, int xs, int ys) {
        List<Character> characters = new ArrayList<>();
        for (int i = xs; i < xs + 3; i++)
            for (int j = ys; j < ys + 3; j++)
                addCharacter(characters, board[i][j]);
        return validate(characters);
    }

    private void addCharacter(List<Character> characters, char c) {
        if (c != '.')
            characters.add(c);
    }

    private boolean validate(List<Character> characters) {
        Set<Character> distinctCharacters = new HashSet<>(characters);
        return characters.size() == distinctCharacters.size();
    }
}
