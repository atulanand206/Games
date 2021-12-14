package com.games.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class I {

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split("");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    private static InputStreamReader inputStream() throws IOException {
        return (System.getenv().containsKey("LOCAL_CODING") && "why in the world not?".equals(System.getenv("LOCAL_CODING")))
                ? fileInputStream() : stdInputStream();
    }

    private static InputStreamReader stdInputStream() {
        return new InputStreamReader(System.in);
    }

    private static InputStreamReader fileInputStream() throws FileNotFoundException {
        return new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
    }

    public static BufferedReader reader(boolean file) throws FileNotFoundException {
        return new BufferedReader(file ? fileInputStream() : stdInputStream());
    }
}
