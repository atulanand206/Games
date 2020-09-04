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

    private int getNextRoll() {
        return new Random().nextInt(4);
    }

    public void roll(int nextRoll) {
        playNextRoll(nextRoll);
        switchPlayer();
    }

    private void playNextRoll(int nextRoll) {
        possiblePositionsForCurrentTurn = getPossiblePositions(nextRoll);
        int indexOfThePieceToBeMoved = 0;
        movePiece(indexOfThePieceToBeMoved, nextRoll);
    }

    public List<Integer> getPossiblePositionsForCurrentTurn() {
        return possiblePositionsForCurrentTurn;
    }

    private List<Integer> getPossiblePositions(int nextRoll) {
        return getPositionsForCurrentPlayer().stream().map(integer -> integer + nextRoll).distinct().collect(Collectors.toList());
    }

    private List<Integer> getPositionsForCurrentPlayer() {
        return isFirstPlayer() ? firstPlayerPositions : secondPlayerPositions;
    }

    private void movePiece(int indexOfThePieceToBeMoved, int placesToMove) {
        if (isFirstPlayer())
            movePlayerPiece(indexOfThePieceToBeMoved, placesToMove, firstPlayerPositions);
        else
            movePlayerPiece(indexOfThePieceToBeMoved, placesToMove, secondPlayerPositions);
    }

    private void movePlayerPiece(int indexOfThePieceToBeMoved, int placesToMove, List<Integer> playerPositions) {
        playerPositions.set(indexOfThePieceToBeMoved, placesToMove + playerPositions.get(indexOfThePieceToBeMoved));
    }

    private void switchPlayer() {
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

    private void printList(List<Integer> list) {
        for (Integer i : list)
            System.out.print(i + ", ");
        System.out.println();
    }
}
