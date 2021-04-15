package com.games.CF.bearAndHouseQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peakY = getPeak(br, true, 0);
        int peakX = getPeak(br, false, 0);
        int triBaseX = getPeak(br, false, 2 * peakX);
        int area = triBaseX * (peakY - 2 * peakX) + 4 * peakX * peakX;
        System.out.printf("! %d\n", area);
    }

    private static int getPeak(BufferedReader br, boolean isY, int other) throws IOException {
        int y = 1000;
        int prevY = 1000, lastY = 0;
        int peakY = -1;
        while (true) {
            System.out.printf("? %d %d\n", isY ? other : y, isY ? y : other);
            System.out.flush();
            String res = br.readLine();
            if (lastY == prevY) {
                peakY = lastY;
            }
            switch (res) {
                case "NO":
                    prevY = y;
                    y = (lastY + y) / 2;
                    break;
                case "YES":
                    lastY = y;
                    if (prevY == y + 1) {
                        peakY = y;
                        break;
                    }
                    y = (prevY + y) / 2;
                    break;
            }
            if (peakY != -1) {
                break;
            }
        }
        return peakY;
    }
}
