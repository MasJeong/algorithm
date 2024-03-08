package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 도키도키 간식드리미 - 스택 큐 덱
 */
public class _12789 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        final StringTokenizer st = new StringTokenizer(br.readLine());

        int findNum = 1;
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (input > findNum) {
                while (!stack.isEmpty() && stack.peek() == findNum) {
                    stack.pop();
                    findNum++;
                }

                stack.push(input);
            } else {
                findNum++;
            }
        }

        while (!stack.isEmpty() && stack.peek() == findNum) {
            stack.pop();
            findNum++;
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }

        br.close();
    }
}
