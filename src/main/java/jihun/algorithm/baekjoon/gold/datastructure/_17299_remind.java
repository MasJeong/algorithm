package jihun.algorithm.baekjoon.gold.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오등큰수 - 자료구조
 */
public class _17299_remind {

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        int[] counting = new int[1000001];
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
         * 1 1 2 3 4 2 1
         * 3 3 2 1 1 2 3
         * -1 -1 1 2 2 1 -1
         */

        // 원본 배열
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            counting[seq[i]]++;
        }

        for (int i = 0; i < seq.length; i++) {
            while (!stack.isEmpty() && counting[seq[stack.peek()]] < counting[seq[i]]) {
                answer[stack.pop()] = seq[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append(answer[n - 1]);

        System.out.println(sb);
        br.close();
    }
}
