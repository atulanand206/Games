package com.games.chess.ur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<Integer> safePositions = Arrays.asList(4,8,14);
    public static final String S = "S"; // safe and unoccupied
    public static final String X = "X"; // occupied by p1
    public static final String Y = "Y"; // occupied by p2
    public static final String B = "0"; // unsafe and unoccupied
    public static final String P = "_"; // possibility for next move

    private List<Integer> firstPlayerPositions = new ArrayList<>();
    private List<Integer> secondPlayerPositions = new ArrayList<>();

    public Board() {
    }

    public List<Integer> getSafePositions() {
        return safePositions;
    }

    public String getBoard(List<Integer> firstPlayerPositions, List<Integer> secondPlayerPositions) {
        setLatestPlayerPositions(firstPlayerPositions, secondPlayerPositions);
        return currentBoard();
    }

    private void setLatestPlayerPositions(List<Integer> firstPlayerPositions, List<Integer> secondPlayerPositions) {
        this.firstPlayerPositions.clear();
        this.firstPlayerPositions.addAll(firstPlayerPositions);
        this.secondPlayerPositions.clear();
        this.secondPlayerPositions.addAll(secondPlayerPositions);
    }
    public String currentBoard() {
        return getOuterBorder() + "\n" + getTopRow()
                + "\n" + getInnerBorder() + "\n" + getMidRow() + "\n" + getInnerBorder()
                + "\n" + getBotRow() + "\n" + getOuterBorder();
    }

    private String getOuterBorder() {
        return "| - - - - - - - |       | - - - |";
    }

    private String getInnerBorder() {
        return "| - - - - - - - | - - - | - - - |";
    }

    private String getTopRow() {
        return leftDivider()
                + placeFirstIfOccupied(4) + verticalDivider()
                + placeFirstIfOccupied(3) + verticalDivider()
                + placeFirstIfOccupied(2) + verticalDivider()
                + placeFirstIfOccupied(1)
                + middleDivider()
                + placeFirstIfOccupied(14) + verticalDivider()
                + placeFirstIfOccupied(13)
                + rightDivider();

    }

    private String getMidRow() {
        return leftDivider()
                + placeIfOccupied(5) + verticalDivider()
                + placeIfOccupied(6) + verticalDivider()
                + placeIfOccupied(7) + verticalDivider()
                + placeIfOccupied(8) + verticalDivider()
                + placeIfOccupied(9) + verticalDivider()
                + placeIfOccupied(10) + verticalDivider()
                + placeIfOccupied(11) + verticalDivider()
                + placeIfOccupied(12)
                + rightDivider();
    }

    private String getBotRow() {
        return leftDivider()
                + placeSecondIfOccupied(4) + verticalDivider()
                + placeSecondIfOccupied(3) + verticalDivider()
                + placeSecondIfOccupied(2) + verticalDivider()
                + placeSecondIfOccupied(1)
                + middleDivider()
                + placeSecondIfOccupied(14) + verticalDivider()
                + placeSecondIfOccupied(13)
                + rightDivider();
    }

    private String placeIfOccupied(int position) {
        if (containsFirst(position))
            return X;
        if (containsSecond(position))
            return Y;
        return unoccupiedAndCouldBeSafe(position);
    }

    private String placeFirstIfOccupied(int position) {
        if (containsFirst(position))
            return X;
        return unoccupiedAndCouldBeSafe(position);
    }

    private String placeSecondIfOccupied(int position) {
        if (containsSecond(position))
            return Y;
        return unoccupiedAndCouldBeSafe(position);
    }

    private String unoccupiedAndCouldBeSafe(int position) {
        return isSafePosition(position) ? S : B;
    }

    private boolean isSafePosition(int position) {
        return safePositions.contains(position);
    }

    private boolean containsSecond(int position) {
        return secondPlayerPositions.contains(position);
    }

    private boolean containsFirst(int position) {
        return firstPlayerPositions.contains(position);
    }

    private String leftDivider() {
        return "| ";
    }

    private String verticalDivider() {
        return " | ";
    }

    private String middleDivider() {
        return " |       | ";
    }

    private String rightDivider() {
        return " |";
    }
}
