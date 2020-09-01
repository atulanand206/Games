package com.games.chess.ur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    private int currentPlayer = 0;

    private Board board = new Board();

    private List<Integer> firstPlayerPositions = new ArrayList<>();
    private List<Integer> secondPlayerPositions = new ArrayList<>();

    private List<Integer> possiblePositionsForCurrentTurn = new ArrayList<>();


    public Game() {
        setPiecesPositions();
    }

    private void setPiecesPositions() {
        setPiecePositions(firstPlayerPositions);
        setPiecePositions(secondPlayerPositions);
    }

    private void setPiecePositions(List<Integer> piecePositions) {
        for (int i=0;i<7;i++)
            piecePositions.add(0);
    }

    public void roll() {
        int nextRoll = getNextRoll();
        roll(nextRoll);
    }

    public void roll(int nextRoll) {
        playNextRoll(nextRoll);
        switchPlayer();
    }

    private void playNextRoll(int nextRoll) {
        possiblePositionsForCurrentTurn = getPossiblePositions(nextRoll);
        movePiece(0, nextRoll);
    }

    private void movePiece(int indexOfThePieceToBeMoved, int placesToMove) {
        if (isFirstPlayer())
            movePlayerPiece(indexOfThePieceToBeMoved, placesToMove, firstPlayerPositions);
        else
            movePlayerPiece(indexOfThePieceToBeMoved, placesToMove, secondPlayerPositions);
    }

    private void movePlayerPiece(int indexOfThePieceToBeMoved, int placesToMove, List<Integer> firstPlayerPositions) {
        firstPlayerPositions.set(indexOfThePieceToBeMoved, placesToMove + firstPlayerPositions.get(indexOfThePieceToBeMoved));
    }

    private List<Integer> getPositionsForCurrentPlayer() {
        return isFirstPlayer() ? firstPlayerPositions : secondPlayerPositions;
    }

    private int getNextRoll() {
        return new Random(4).nextInt();
    }

    public void switchPlayer() {
        currentPlayer = isFirstPlayer() ? 1 : 0;
    }

    private boolean isFirstPlayer() {
        return currentPlayer == 0;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void printBoard() {
        System.out.println(boardString());
    }

    public String boardString() {
        return board.getBoard(firstPlayerPositions, secondPlayerPositions);
    }

    public List<Integer> getPossiblePositionsForCurrentTurn() {
        return possiblePositionsForCurrentTurn;
    }

    private List<Integer> getPossiblePositions(int nextRoll) {
        return getPositionsForCurrentPlayer().stream().map(integer -> integer + nextRoll).distinct().collect(Collectors.toList());
    }
}
