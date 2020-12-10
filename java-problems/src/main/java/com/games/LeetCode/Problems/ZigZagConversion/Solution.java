package com.games.LeetCode.Problems.ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int numberOfSets = s.length() / (2 * numRows - 2);
        if (numberOfSets == 0)
            numberOfSets = 1;
        int widthOfOneSet = numRows - 1;
        int totalCharsInOneRow = numberOfSets * widthOfOneSet;
        System.out.println(numberOfSets);
        System.out.println(widthOfOneSet);
        System.out.println(totalCharsInOneRow);
        List<List<Character>> zigzag = new ArrayList<>();
        for (int k = 0; k < numRows; k++)
            zigzag.add(getEmptyRow(totalCharsInOneRow + numRows));
        int i = 0, j = 0, k = 0;
        boolean goingDown = true;
        while (k < s.length() && j < totalCharsInOneRow+numRows) {
            zigzag.get(i).set(j, s.charAt(k++));
            if (i == 0 && !goingDown) {
                goingDown = true;
                i++;
            } else if (i == zigzag.size() - 1 && goingDown) {
                goingDown = false;
                i--;
                j++;
            } else {
                if (goingDown)
                    i++;
                else {
                    i--;
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : zigzag) {
            for (Character character : characters) {
                System.out.printf("%c ", character);
                if (!character.equals(' '))
                    sb.append(character);
            }
            System.out.println();
        }
        return sb.toString();
    }

    private List<Character> getEmptyRow(int totalCharsInOneRow) {
        List<Character> characters = new ArrayList<>();
        for (int p = 0; p < totalCharsInOneRow; p++)
            characters.add(' ');
        return characters;
    }

    //P   A   H   N
    //A P L S I I G
    //Y   I   R

    // 3 -> (0,3), (4,7), (8,11), (12,15)

    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I

    // 4 -> (0, 5), (6, 11)

    // n -> n + n-2: length of chars in one set
    // n -> n-1: width;
}
