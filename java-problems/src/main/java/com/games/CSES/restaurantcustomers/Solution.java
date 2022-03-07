package com.games.CSES.restaurantcustomers;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Problem: CSES 1619
 *
 * @author atulanand
 */

class Item {
    int loc;
    int val;

    static Item of(int loc, int val) {
        Item it = new Item();
        it.loc = loc;
        it.val = val;
        return it;
    }

    int getLoc() {
        return loc;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        List<Item > queue = new ArrayList<>();
        int[][] edges = new int[t][];
        for (int i = 0; i < t; i++) {
            edges[i] = inputIntArray(br);
        }
        for (int[] spec : edges) {
            queue.add(Item.of(spec[0], 1));
            queue.add(Item.of(spec[1], -1));
        }
        queue.sort(Comparator.comparing(Item::getLoc).thenComparing(x -> x.val));
        int max = 0;
        int cnt = 0;
        for (Item it : queue) {
            cnt += it.val;
            max = Math.max(max, cnt);
        }
        System.out.println(max);
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

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
