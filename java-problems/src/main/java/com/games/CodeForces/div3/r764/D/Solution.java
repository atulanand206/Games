package com.games.CodeForces.div3.r764.D;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: CodeForces 1624D
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(String str, int k) {
        Map<Character, Integer> freq = charMap(str);

        int odds = 0;
        List<Integer> evens = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int val = entry.getValue() - (entry.getValue() % 2 != 0 ? 1 : 0);
            if (val != 0) evens.add(val);
            if (entry.getValue() % 2 != 0) odds++;
        }
        Collections.sort(evens);

        O.debug(S.string(evens));
        O.debug(S.string(odds));

        return search(evens, odds, str.length(), k);
    }

    private static int search(List<Integer> evens, int odds, int n, int k) {
        int s = 1, e = n / k;
        int ans = 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int val = isValid(evens, odds, n, mid);
            O.debug(S.string(mid + " " + val + " "));
            if (val >= k) {
                ans = Math.max(ans, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            O.debugNewLine();
        }
        return ans;
    }

    private static int isValid(List<Integer> evens, int odds, int n, int k) {
        if (odds > k) return 1;
        List<Integer> vals = new ArrayList<>();
        int sum = 0;
        for (int i : evens) {
            if (sum + i <= k) {
                sum += i;
            } else {
                if (sum != 0)
                    vals.add(sum);
                sum = i;
            }
        }
        if (vals.size() == 0) return 1;
        Collections.sort(vals);
        int min = Collections.min(vals);
//        for (int i = 0; i < odds && i < vals.size(); i++) vals.set(i, vals.get(i) + 1);
        O.debug(S.string(vals));
        return min;
    }

    private static Map<Character, Integer> charMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) map.merge(ch, 1, Integer::sum);
        return map;
    }


    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] x = inputArray(br);
            String in = br.readLine().trim();
            sb.append(solve(in, x[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
