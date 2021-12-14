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

    private static final int MOD = (int) 1E9 + 7;

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
        String template = br.readLine();
        br.readLine();
        Map<Character, Map<Character, Character>> rules = getRules(br);
        List<Character> list = getCharacters(template);
        for (int i = 0; i < 30; i++) insertRules(list, rules);
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
        O.debug(new Date().toString());
        O.debug(S.string(list.size()));
    }

    /*
Tue Dec 14 21:55:14 IST 20217
Tue Dec 14 21:55:14 IST 202113
Tue Dec 14 21:55:14 IST 202125
Tue Dec 14 21:55:14 IST 202149
Tue Dec 14 21:55:14 IST 202197
Tue Dec 14 21:55:14 IST 2021193
Tue Dec 14 21:55:14 IST 2021385
Tue Dec 14 21:55:14 IST 2021769
Tue Dec 14 21:55:14 IST 20211537
Tue Dec 14 21:55:14 IST 20213073
Tue Dec 14 21:55:14 IST 20216145
Tue Dec 14 21:55:14 IST 202112289
Tue Dec 14 21:55:14 IST 202124577
Tue Dec 14 21:55:14 IST 202149153
Tue Dec 14 21:55:15 IST 202198305
Tue Dec 14 21:55:16 IST 2021196609
Tue Dec 14 21:55:21 IST 2021393217
Tue Dec 14 21:55:39 IST 2021786433
Tue Dec 14 21:56:35 IST 20211572865
Tue Dec 14 22:03:24 IST 20213145729
Still struggling with Step 21. Gotta think of a better approach for calculating 40 steps.
     */

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
