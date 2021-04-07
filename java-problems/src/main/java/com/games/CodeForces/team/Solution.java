package com.games.CodeForces.team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problems = Integer.parseInt(br.readLine());
        int result = 0;
        while (problems-- > 0)
            result += Arrays.stream(br.readLine().split(" "))
                    .filter(x -> x.equals("1")).count() > 1 ? 1 : 0;
        System.out.println(result);
    }
}
