package com.games.chess.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class InputUtils {

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
