package com.games.chess.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static List<Integer> listOf(Integer... ints) {
        Integer[] integers = new Integer[ints.length];
        System.arraycopy(ints, 0, integers, 0, ints.length);

        for (int i = 0;i<ints.length;i++)
            integers[i] = ints[i];
        return Arrays.asList(integers);
    }

    public static List<String> listOf(String... ints) {
        String[] integers = new String[ints.length];
        System.arraycopy(ints, 0, integers, 0, ints.length);

        for (int i = 0;i<ints.length;i++)
            integers[i] = ints[i];
        return Arrays.asList(integers);
    }

    public static List<Integer> intList(Integer... i) {
        return Arrays.asList(i);
    }

    public static <T> void print(List<T> list) {
        for (T in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static void print(int[] list) {
        for (int in : list)
            System.out.print(in + ", ");
        System.out.println();
    }
}
