package com.games.chess.chef;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Birbal {
    static int cuts(ArrayList<Integer> lengths) {
        int cuts = 0;
        while (lengths.size() != 0) {
            Integer max = Collections.max(lengths);
            List<Integer> indexesToRemove = new ArrayList<>();
            for (int i=0;i<lengths.size();i++)
                if (max.equals(lengths.get(i)))
                    indexesToRemove.add(i);
            Collections.reverse(indexesToRemove);
            for (int index : indexesToRemove)
                lengths.remove(index);
            cuts ++;
        }
        return cuts;
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> candles = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            int cuts = cuts(new ArrayList<>(candles));
            bufferedWriter.write(String.valueOf(cuts));
            bufferedWriter.newLine();
        }

        br.close();
        bufferedWriter.close();


//        Scanner br = new Scanner(System.in);
//        int t = br.nextInt();
//        while (t-- > 0) {
//            int n = br.nextInt();
//            String[] sizes = br.nextLine().split(" ");
//            System.out.println(cuts(asIntList(sizes)));
//        }


//        Scanner br = new Scanner(System.in);
//        int t = br.nextInt();
//        while (t-- > 0) {
//            int n = br.nextInt();
//            int[] sizes = new int[n];
//            for (int i=0;i<n;i++)
//                sizes[i] = br.nextInt();
//            System.out.println(cuts(asIntList(sizes)));
//        }
    }

    private static ArrayList<Integer> asIntList(int[] sizes) {
        ArrayList<Integer> s = new ArrayList<>();
        for (int sz : sizes)
            s.add(sz);
        return s;
    }

    private static ArrayList<Integer> asIntList(String[] sizes) {
        ArrayList<Integer> s = new ArrayList<>();
        for (String sz : sizes)
            s.add(Integer.parseInt(sz));
        return s;
    }
}
