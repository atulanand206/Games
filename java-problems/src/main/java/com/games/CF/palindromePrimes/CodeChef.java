package com.games.CF.palindromePrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

public class CodeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String s = maxFromDigits(word);
        long limit = Long.parseLong(s);
        Set<String> words = new TreeSet<>();
        boolean[] booleans = sieveOfEratosthenes((int) limit);
//        permutation(words, s);
        for (String st : words) if (booleans[Integer.parseInt(st)]) System.out.println(st);

//        Vector<Long> integers = segmentedSieve(limit);
//        for (int i : integers) System.out.printf("%d ", i);
    }

    static String maxFromDigits(String word) {
        List<Character> characters = new ArrayList<>();
        for (char ch : word.toCharArray()) characters.add(ch);
        Collections.sort(characters);
        Collections.reverse(characters);
        StringBuilder sb = new StringBuilder();
        for (char ch : characters) sb.append(ch);
        return sb.toString();
    }

    static List<Integer> segmentedSieve(int n) {
        int limit = (int) (floor(sqrt(n)) + 1);
        List<Integer> pr = new ArrayList<>(primes(sieveOfEratosthenes(limit)));
        int low = limit;
        int high = 2 * limit;
        while (low < n) {
            if (high >= n) high = n;
            boolean[] mark = new boolean[limit + 1];
            Arrays.fill(mark, true);
            for (int i : pr) {
                int lowLim = (int) (floor(low / i) * i);
                if (lowLim < low) lowLim += i;
                for (int j = lowLim; j < high; j += i) mark[j - low] = false;
            }
            for (int i = low; i < high; i++) if (mark[i - low]) pr.add(i);
            low += limit;
            high += limit;
        }
        return pr;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 2; i <= n; i++) prime[i] = true;
        for (int p = 2; p * p <= n; p++) if (prime[p]) for (int i = p * p; i <= n; i += p) prime[i] = false;
        return prime;
    }

    static List<Integer> primes(boolean[] arr) {
        List<Integer> pr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) if (arr[i]) pr.add(i);
        return pr;
    }
}
