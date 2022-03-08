package com.games.CodeForces.B.berlandmusic;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: CF 1622B
 *
 * @author atulanand
 */

public class Solution {
    static class Item {
        int rating;
        int liked;
        int index;
        static Item of (int rating, int liked, int index) {
            Item it = new Item();
            it.rating = rating;
            it.liked = liked;
            it.index = index;
            return it;
        }

        public int getLiked() {
            return liked;
        }

        public int getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return index + " " + rating + " " + liked;
        }
    }
    static class Result {

        public String solve(int[] ratings, int[] liked) {
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < ratings.length; i++) {
                items.add(Item.of(ratings[i], liked[i], i));
            }
            O.debug(S.string(items));
            items.sort(Comparator
                    .comparing(Item::getRating, Comparator.reverseOrder()));

            for (int i = 0; i < ratings.length; i++) {
                Item element = items.get(i);
                element.liked = liked[i];
                items.set(i, element);
            }

            O.debug(S.string(items.stream().map(x -> x.index).collect(Collectors.toList())));
            items.sort(Comparator.comparing(Item::getLiked, Comparator.reverseOrder()));
            O.debug(S.string(items.stream().map(x -> x.index).collect(Collectors.toList())));
            return  "YES";
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
            sb.append(new Result().solve(inputIntArray(br), inputIntArrays(br))).append("\n");
        }
        System.out.println(sb);
    }

    private static char[] inputCharArray(BufferedReader br) throws IOException {
        return br.readLine().trim().toCharArray();
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static int[] inputIntArrays(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split("");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
