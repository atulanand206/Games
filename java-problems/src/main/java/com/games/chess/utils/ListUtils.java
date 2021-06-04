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

    public static List<Integer> intList(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (String str : list)
            result.add(Integer.parseInt(str));
        return result;
    }

    public static <T> void printi(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ": ");
            System.out.print(list.get(i) + ", ");
            System.out.println();
        }
    }

    public static <T> void print(List<T> list) {
        for (T in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static <T> void print(Set<T> list) {
        for (T in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static <T> void print2Di(List<List<T>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ": ");
            print(list.get(i));
        }
        System.out.println();
    }

    public static <T> void print2D(List<List<T>> list) {
        for (List<T> in : list)
            print(in);
        System.out.println();
    }

    public static void print(boolean[] list) {
        for (boolean in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static void print(int[] list) {
        for (int in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static void print(long[] list) {
        for (long in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static void print(double[] list) {
        for (double in : list)
            System.out.printf("%.9f, ", in);
        System.out.println();
    }

    public static void print(char[] list) {
        for (char in : list)
            System.out.print(in + ", ");
        System.out.println();
    }

    public static void print3D(int[][][] list) {
        for (int[][] in : list)
            print2D(in);
        System.out.println();
    }

    public static void print2D(int[][] list) {
        for (int[] in : list)
            print(in);
        System.out.println();
    }

    public static void print2D(String[][] list) {
        for (String[] in : list)
            print(in);
        System.out.println();
    }

    public static void print2D(long[][] list) {
        for (long[] in : list)
            print(in);
        System.out.println();
    }

    public static void print2D(long[][] list, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.printf("%d ", list[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print2D(double[][] list) {
        for (double[] in : list)
            print(in);
        System.out.println();
    }

    public static void print(String[] list) {
        for (String in : list)
            System.out.print(in + ", \n");
        System.out.println();
    }

    public static void printS(String[] list) {
        for (String in : list)
            System.out.print(in + ", ");
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

    public static void printDpi(int[][] dp, int[] list) {
        int digitsInMax = digitsInPair(max(dp), min(dp));
        System.out.printf("%s ", formatted(digitsInMax, "-"));
        printFormatted(digitsInMax, list);
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("%s ", formatted(digitsInMax, list[i]));
            for (int item : dp[i])
                System.out.printf("%s ", formatted(digitsInMax, item));
            System.out.println();
        }
    }

    public static void printDp(int[][] dp,List<Integer> list) {
        int digitsInMax = digitsInPair(max(dp), min(dp));
        System.out.printf("%s ", formatted(digitsInMax - 1, "-"));
        System.out.printf("%s ", formatted(digitsInMax, "-"));
        printFormatted(digitsInMax, list);
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("%s ", i > 0 ? formatted(digitsInMax, list.get(i)) : formatted(digitsInMax, "-"));
            for (int item : dp[i])
                System.out.printf("%s ", formatted(digitsInMax, item));
            System.out.println();
        }
    }

    public static void printDp(int[][] dp, int[] list) {
        int digitsInMax = digitsInPair(max(dp), min(dp));
        System.out.printf("%s ", formatted(digitsInMax, "-"));
        System.out.printf("%s ", formatted(digitsInMax, "-"));
        printFormatted(digitsInMax, list);
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("%s ", i > 0 ? formatted(digitsInMax, list[i - 1]) : formatted(digitsInMax, "-"));
            for (int item : dp[i])
                System.out.printf("%s ", formatted(digitsInMax, item));
            System.out.println();
        }
    }

    public static void printFormatted(int digitsInMax, List<Integer> list) {
        for (int in : list)
            System.out.printf("%s ", formatted(digitsInMax, in));
        System.out.println();
    }


    public static void printFormatted(int digitsInMax, int[] list) {
        for (int in : list)
            System.out.printf("%s ", formatted(digitsInMax, in));
        System.out.println();
    }

    private static String formatted(int digitsInMax, int num) {
        return String.format("%" + digitsInMax + "d", num);
    }

    private static String formatted(int digitsInMax, String num) {
        return String.format("%" + digitsInMax + "s", num);
    }

    private static int digitsInPair(int max, int min) {
        return Math.max(digitsInNumber(max), digitsInNumber(min));
    }

    private static int digitsInNumber(int max) {
        if (max > 0) {
            return digitsInPositiveInteger(max);
        } else if (max == 0)
            return 1;
        else {
            return 1 + digitsInPositiveInteger(Math.abs(max));
        }
    }

    private static int digitsInPositiveInteger(int max) {
        int i = 0;
        while (max > 0) {
            max = max / 10;
            i++;
        }
        return i;
    }

    private static int max(int[][] dp) {
        int max = Integer.MIN_VALUE;
        for (int[] r : dp)
            for (int i : r)
                max = Math.max(i, max);
        return max;
    }

    private static int min(int[][] dp) {
        int min = Integer.MAX_VALUE;
        for (int[] r : dp)
            for (int i : r)
                min = Math.min(i, min);
        return min;
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

    public static int[][] array2DOf(String str) {
        return array2DOf(list2DOf(str));
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

    public static long[][] long2DOf(int[][] arrays) {
        long[][] array = new long[arrays.length][];
        int i = 0;
        for (int[] nestedList : arrays) {
            long[] tsi = new long[nestedList.length];
            for (int j = 0; j < tsi.length; j++)
                tsi[j] = nestedList[j];
            array[i++] = tsi;
        }
        return array;
    }

}
