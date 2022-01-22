package com.games.CodeForces.div2.r767.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: CodeForces 1629A
 *
 * @author atulanand
 */
public class Solution {

    static class Item {
        int a;
        int b;

        static Item of(int a, int b) {
            Item it = new Item();
            it.a = a;
            it.b = b;
            return it;
        }

        public int getA() {
            return a;
        }

        public int getNegB() {
            return -b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }


    public static int solve(int[] a, int[] b, int k) {
        List<Item> collect = IntStream.range(0, a.length)
                .mapToObj(i -> Item.of(a[i], b[i]))
                .sorted(Comparator.comparingInt(Item::getA).thenComparingInt(Item::getNegB))
                .collect(Collectors.toList());
        int sum = k;
        for (int i = 0; i < collect.size() && collect.get(i).a <= sum; i++) sum += collect.get(i).b;
        return sum;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] y = inputIntArray(br);
            int[] a = inputIntArray(br);
            int[] b = inputIntArray(br);
            sb.append(solve(a, b, y[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
