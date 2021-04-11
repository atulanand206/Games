package com.games.CF.chefAndPicnic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeChef {

    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(new InputStreamReader(System.in));
        int t = br.nextInt();
        while (t-- > 0) {
            long n = br.nextLong();
            long m = 0;
            long prevMax = br.nextLong();
            while (--n > 0) {
                long next = br.nextLong();
                if (prevMax > next) {
                    m += prevMax - next;
                } else {
                    prevMax = next;
                }
            }
            System.out.println(m);
        }
    }
}
