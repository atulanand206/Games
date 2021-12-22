package com.games.gaoc;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Advent of code 14/12/2021
 *
 * @author atulanand
 */
public class Polymerization {

    private static final int iterations = 3;

    private static final int MOD = (int) 1E9 + 7;

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
        String template = br.readLine();
        br.readLine();
        Map<Character, Map<Character, Character>> rules = getRules(br);
        part1(template, rules);
        part2(template, rules);
    }

    private static void part2(String template, Map<Character, Map<Character, Character>> rules) {
        Map<Character, Map<Character, Long>> characterMap = initialCharCountMap(template);
//        O.debug(S.string(characterMap));
        for (int i = 0; i < iterations; i++) {
            characterMap = stage(characterMap, rules);
//            O.debug(S.string(characterMap));
        }
        O.debug(S.string(characterMap));
    }

    private static Map<Character, Map<Character, Long>> stage(Map<Character, Map<Character, Long>> characterMap, Map<Character, Map<Character, Character>> rules) {
        O.debug("Start \n" + S.string(characterMap));
        Map<Character, Map<Character, Long>> nextStage = new HashMap<>();
        for (Map.Entry<Character, Map<Character, Long>> entry : characterMap.entrySet()) {
            char first = entry.getKey();
            Map<Character, Character> ruleFirst = rules.getOrDefault(first, new HashMap<>());
            for (Map.Entry<Character, Long> nEntry : entry.getValue().entrySet()) {
                Map<Character, Long> firstNextMap = nextStage.getOrDefault(first, new HashMap<>());
                char second = nEntry.getKey();
                firstNextMap.remove(second);
                long secondCount = entry.getValue().getOrDefault(second, 0L);
                char toInsert = ruleFirst.getOrDefault(second, ' ');
                O.debug(String.format("first: %c, second: %c, insert: %c \n", first, second, toInsert));
                if (toInsert != ' ') {
                    Map<Character, Long> insertNextMap = nextStage.getOrDefault(toInsert, new HashMap<>());
                    firstNextMap.put(toInsert, secondCount);
                    insertNextMap.merge(second, secondCount, Long::sum);
                    nextStage.put(toInsert, insertNextMap);
                } else {
                    firstNextMap.put(second, secondCount);
                }
                nextStage.put(first, firstNextMap);
            }
        }
        return nextStage;
    }

    private static Map<Character, Map<Character, Long>> initialCharCountMap(String template) {
        Map<Character, Map<Character, Long>> map = new HashMap<>();
        char[] chars = template.toCharArray();
        for (int i = 0; i + 1 < template.length(); i++) {
            char f = chars[i];
            char s = chars[i + 1];
            Map<Character, Long> next = map.getOrDefault(f, new HashMap<>());
            next.merge(s, 1L, Long::sum);
            map.put(f, next);
        }
        return map;
    }

    private static void part1(String template, Map<Character, Map<Character, Character>> rules) {
        O.debug(S.string(template));
        List<Character> list = getCharacters(template);
//        O.debug(S.string(list.stream().map(String::valueOf).collect(Collectors.joining())));

        for (int i = 0; i < iterations; i++) {
            insertRules(list, rules);
        }
        Collection<Long> counts = getCountsList(list);
        long diff = getMaxMinDiff(counts);
        O.debug(S.string(diff));
    }

    private static long getMaxMinDiff(Collection<Long> counts) {
        long min = Collections.min(counts);
        long max = Collections.max(counts);
        return max - min;
    }

    private static Collection<Long> getCountsList(List<Character> list) {
        Map<Character, Long> chars = new HashMap<>();
        for (Character ch : list) chars.merge(ch, 1L, Long::sum);
        return chars.values();
    }

    private static List<Character> getCharacters(String template) {
        return Arrays.stream(template.split(""))
                .map(x -> x.toCharArray()[0])
                .collect(Collectors.toList());
    }

    private static void insertRules(List<Character> list, Map<Character, Map<Character, Character>> rules) {
        int k = 0;
        while (k + 1 < list.size()) {
            Character f = list.get(k);
            Character s = list.get(k + 1);
            Map<Character, Character> next = rules.getOrDefault(f, new HashMap<>());
            Character x = next.getOrDefault(s, ' ');
            if (x != ' ') {
                list.add(k + 1, x);
                k++;
            }
            k++;
        }
        O.debug(S.string(list.stream().map(String::valueOf).collect(Collectors.joining())));
    }

    private static Map<Character, Map<Character, Character>> getRules(BufferedReader br) throws IOException {
        Map<Character, Map<Character, Character>> rules = new HashMap<>();
        while (br.ready()) {
            String[] rule = br.readLine().split(" -> ");
            char[] pair = rule[0].toCharArray();
            char[] target = rule[1].toCharArray();
            Map<Character, Character> next = rules.getOrDefault(pair[0], new HashMap<>());
            next.put(pair[1], target[0]);
            rules.put(pair[0], next);
        }
        return rules;
    }
}
