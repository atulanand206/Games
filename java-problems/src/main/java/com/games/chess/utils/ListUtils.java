package com.games.chess.utils;

import java.util.*;

public class ListUtils {
    public static List<Integer> listOf(Integer... ints) {
        Integer[] integers = new Integer[ints.length];
        System.arraycopy(ints, 0, integers, 0, ints.length);

        for (int i = 0; i < ints.length; i++)
            integers[i] = ints[i];
        return Arrays.asList(integers);
    }

    public static List<String> listOf(String... ints) {
        String[] integers = new String[ints.length];
        System.arraycopy(ints, 0, integers, 0, ints.length);

        for (int i = 0; i < ints.length; i++)
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

    public static <T> void print2D(List<List<T>> list) {
        for (List<T> in : list)
            print(in);
        System.out.println();
    }

    public static void print(int[] list) {
        for (int in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static void print2D(int[][] list) {
        for (int[] in : list)
            print(in);
        System.out.println();
    }

    public static void print(String[] list) {
        for (String in : list)
            System.out.print(in + ", \n");
        System.out.println();
    }

    public static <E, V> void print(Map<E, V> map) {
        for (Map.Entry<E, V> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.print(entry.getValue());
            System.out.println();
        }
        System.out.println();
    }

    public static List<List<Integer>> list2DOf(String str) {
        List<List<Integer>> lists = new ArrayList<>();
        if (str.isEmpty())
            return lists;
        str = str.substring(1, str.length() - 1);
        String[] split = str.split("\\]");
        for (String s : split) {
            s = s.replace(",[", "").replace("[", "");
            if (s.length() == 0)
                lists.add(new ArrayList<>());
            else {
                String[] sp = s.split(",");
                List<Integer> nums = new ArrayList<>();
                for (String spl : sp) {
                    spl = spl.replace(",", "");
                    nums.add(Integer.parseInt(spl));
                }
                lists.add(nums);
            }
        }
        return lists;
    }

    public static int[][] array2DOf(List<List<Integer>> lists) {
        int[][] array = new int[lists.size()][];
        int i = 0;
        for (List<Integer> nestedList : lists) {
            Integer[] ts = nestedList.toArray(new Integer[nestedList.size()]);
            int[] tsi = new int[ts.length];
            for (int j = 0; j < tsi.length; j++)
                tsi[j] = ts[j];
            array[i++] = tsi;
        }
        return array;
    }

    public static List<List<Integer>> list2DOf(int[][] arrays) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] array : arrays) {
            List<Integer> list = new ArrayList<>();
            for (int anArray : array) {
                list.add(anArray);
            }
            lists.add(list);
        }
        return lists;
    }

}
