package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 스택 수열 - 자료구조
 */
public class _1874 {

    private static int pointer = -1;
    private static int size = 0;

    private static void push(int[] stack, int val) {
        stack[++pointer] = val;
        size++;
    }

    private static int pop(int[] stack) {
        if(pointer < 0) {
            return -1;
        }

        size--;
        return stack[pointer--];
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if(size <= 0) {
            return 1;
        }

        return 0;
    }

    private static int top(int[] stack) {
        if(size <= 0) {
            return -1;
        }

        return stack[size - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
            push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop
            [4, 3, 6, 8, 7, 5, 2, 1]
         */
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int startIdx = 0;

        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input > startIdx) {
                for (int i = startIdx + 1; i <= input; i++) {
                    push(stack, i);
                    sb.append("+\n");
                }

                startIdx = input;
            } else if (top(stack) != input) {
                System.out.println("NO");
                return;
            }

            pop(stack);
            sb.append("-\n");
        }

        System.out.println(sb);
        br.close();
    }
}
