package com.games.chess.ur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void currentPlayerAfterARoll() {
        roll();
        Assertions.assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    void currentPlayerAfterEightRolls() {
        rollMany(8);
        Assertions.assertEquals(0, game.getCurrentPlayer());
    }

    @Test
    void currentPlayerAfterMultipleRolls() {
        rollMany(8);
        Assertions.assertEquals(0, game.getCurrentPlayer());
        rollMany(5);
        Assertions.assertEquals(1, game.getCurrentPlayer());
        rollMany(5);
        Assertions.assertEquals(0, game.getCurrentPlayer());
    }

    @Test
    void possiblePlacesAfterOneRoll() {
        roll();
        Assertions.assertEquals(1, game.getPossiblePositionsForCurrentTurn().size());
    }

    @Test
    void possiblePlacesAfterRollingOne() {
        game.roll(1);
        Assertions.assertEquals(1, game.getPossiblePositionsForCurrentTurn().get(0));
    }

    @Test
    void possiblePlacesAfterRollingOneTwoThree() {
        game.roll(1);
        game.roll(2);
        game.roll(3);
        Assertions.assertEquals(4, game.getPossiblePositionsForCurrentTurn().get(0));
    }

    @Test
    void rollOneTurn() {
        game.roll(5);
        String border1 = "| - - - - - - - |       | - - - |";
        String topRow  = "| S | 0 | 0 | 0 |       | S | 0 |";
        String border2 = "| - - - - - - - | - - - | - - - |";
        String midRow  = "| X | 0 | 0 | S | 0 | 0 | 0 | 0 |";
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
        Assertions.assertEquals(boardStringToPrint, game.boardString());
    }

    @Test
    void rollMultipleTurn() {
        game.roll(5);
        game.roll(4);
        game.roll(2);
        String border1 = "| - - - - - - - |       | - - - |";
        String topRow  = "| S | 0 | 0 | 0 |       | S | 0 |";
        String border2 = "| - - - - - - - | - - - | - - - |";
        String midRow  = "| 0 | 0 | X | S | 0 | 0 | 0 | 0 |";
        String border3 = "| - - - - - - - | - - - | - - - |";
        String botRow  = "| Y | 0 | 0 | 0 |       | S | 0 |";
        String border4 = "| - - - - - - - |       | - - - |";
        String boardStringToPrint = border1 + "\n"
                + topRow + "\n"
                + border2 + "\n"
                + midRow + "\n"
                + border3 + "\n"
                + botRow + "\n"
                + border4;
        Assertions.assertEquals(boardStringToPrint, game.boardString());
    }

    @Test
    void rollMultipleTurns() {
        game.roll(5);
        game.roll(4);
        game.roll(2);
        game.roll(2);
        game.roll(5);
        String border1 = "| - - - - - - - |       | - - - |";
        String topRow  = "| S | 0 | 0 | 0 |       | S | 0 |";
        String border2 = "| - - - - - - - | - - - | - - - |";
        String midRow  = "| 0 | Y | 0 | S | 0 | 0 | 0 | X |";
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
        Assertions.assertEquals(boardStringToPrint, game.boardString());
    }

    private void roll() {
        game.roll();
    }

    private void rollMany(int times) {
        for (int i=0;i<times;i++)
            game.roll();
    }
}
