package com.games.chess.chef;

import com.games.chess.utils.ListUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static com.games.chess.utils.ListUtils.*;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeaderBoardTest {

    @Test
    void nothing() {
        List<Integer> stringAnagram = stringAnagram(listOf("heater", "cold", "clod", "reheat", "docl"), listOf("codl", "heater", "abcd"));
        List<Integer> expected = listOf(3, 2, 0);
        print(stringAnagram);
        print(expected);
        Assertions.assertTrue(CollectionUtils.isEqualCollection(expected, stringAnagram));
    }

    public static List<String> mostActive(List<String> customers) {
        Map<String, Integer> counts = new TreeMap<>(Collections.reverseOrder());
        customers.forEach(customer -> counts.merge(customer, 1, Integer::sum));
        List<String> traders = new ArrayList<>();
        counts.forEach((key, value) -> { if (((double) value) / customers.size() >= 0.05) traders.add(key); });
        Collections.sort(traders);
        return traders;
    }

    private static Map<Character, Integer> map(String a) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : a.toCharArray())
            map.merge(c, 1, Integer::sum);
        return map;
    }

    private static boolean isAnagram(Map<Character, Integer> a, String b) {
        return (a.equals(map(b)));
    }

    private static int numberOfAnagrams(Map<Map<Character, Integer>, Integer> dictionary, String query) {
        long count = dictionary.entrySet().stream().filter(word -> isAnagram(word.getKey(), query)).mapToLong(Map.Entry::getValue).sum();
        return (int) count;
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Map<Character, Integer>> dictionaryAnagramsMap = dictionary.stream().map(LeaderBoardTest::map).collect(toList());
        Map<Map<Character, Integer>, Integer> dictionaryMapWithCount = new HashMap<>();
        dictionaryAnagramsMap.forEach(anagram -> dictionaryMapWithCount.merge(anagram, 1, Integer::sum));
        List<Integer> counts = new ArrayList<>();
        query.forEach(word -> counts.add(numberOfAnagrams(dictionaryMapWithCount, word)));
        return counts;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int dictionaryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dictionary = IntStream.range(0, dictionaryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> query = IntStream.range(0, queryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        long time = Calendar.getInstance().getTimeInMillis();
        print(stringAnagram(dictionary, query));
        long nowTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(nowTime - time);

        bufferedReader.close();
    }

    @Test
    void anagram() {
    }

    static List<Integer> toLis(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int arr : array)
            list.add(arr);
        return list;
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        Set<Integer> scoresWithoutDuplicates = new TreeSet<>(Collections.reverseOrder());
        for (int sc : scores)
            scoresWithoutDuplicates.add(sc);
        int[] resultArray = new int[alice.length];
        List<Integer> items = new ArrayList<>(scoresWithoutDuplicates);
        print(items);
        print(alice);
        int resultArrayIndex = 0;
        int scoreToFit = alice[resultArrayIndex];
        for (int i = 0; i < alice.length; i++) {
            System.out.println(items.get(i));
            System.out.println(i);
//            if (scoreToFit)
//            if (alice[i]>items.get(i)) {
//                resultArray[i] =
//            }
//            if (items.get(i - 1) >= alice[resultArrayIndex])
//                resultArray[resultArrayIndex] = i ;
            resultArrayIndex++;
        }
        print(resultArray);
        return resultArray;
    }
}
