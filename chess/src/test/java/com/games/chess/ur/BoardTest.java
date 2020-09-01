package com.games.chess.ur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void safePositions() {
        Assertions.assertIterableEquals(() -> Arrays.asList(new Object[] {4,8,14}).iterator(), board.getSafePositions());
    }

    @Test
    void printStartBoardState() {
        String border1 = "| - - - - - - - |       | - - - |";
        String topRow  = "| S | 0 | 0 | 0 |       | S | 0 |";
        String border2 = "| - - - - - - - | - - - | - - - |";
        String midRow  = "| 0 | 0 | 0 | S | 0 | 0 | 0 | 0 |";
        String border3 = "| - - - - - - - | - - - | - - - |";
        String botRow  = "| S | 0 | 0 | 0 |       | S | 0 |";
        String border4 = "| - - - - - - - |       | - - - |";
        String boardStringToPrint = border1 + "\n"
                + topRow + "\n"
                + border2 + "\n"
                + midRow + "\n"
                + border3 + "\n"
                + botRow + "\n"
                + border4;
        Assertions.assertEquals(boardStringToPrint, board.currentBoard());
    }

}
