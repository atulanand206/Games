package com.games.CodeForces.D.maxxorsecondary;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

/**
 * Problem: CodeForces 281D
 *
 * @author atulanand
 */
public class Solution {

    public int solve(int[] A) {
        int[] stack = getStack(A);
        O.debug(S.string(stack));
        sequences(stack);
        return 0;
    }

    private void sequences(int[] stack) {
        for (int k = 1; k <= stack.length; k++) {
            for (int i = 0; i + k - 1 < stack.length; i++) {
                int j = i;
                
            }
        }
    }

    int largest = Integer.MIN_VALUE, second_largest = Integer.MIN_VALUE;

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();
    private final Stack<Integer> stack3 = new Stack<>();

    private void push(int x) {
        stack1.push(x);
        if (x >= largest) {
            second_largest = largest;
            largest = x;
        } else if (x > second_largest) {
            second_largest = x;
        }
        stack2.push(largest);
        stack3.push(second_largest);
    }

    private int pop() {
        second_largest = stack3.pop();
        largest = stack2.pop();
        int now = stack1.pop();
        O.debug(S.string(now + " " + largest + " " + second_largest));
        return second_largest == Integer.MIN_VALUE ? 0 : second_largest;
    }

    private int[] getStack(int[] A) {
        int[] ints = new int[A.length];
        for (int i : A) push(i);
        for (int i = A.length - 1; i >= 0; i--) {
            ints[i] = pop();
        }
        return ints;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            sb.append(new Solution().solve(inputIntArray(br))).append("\n");
        }
        System.out.println(sb);
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
