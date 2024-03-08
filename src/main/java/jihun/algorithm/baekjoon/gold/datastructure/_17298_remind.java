package jihun.algorithm.baekjoon.gold.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오큰수 - 자료구조
 */
public class _17298_remind {

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 원본 배열
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }

            stack.push(i);
        }

        /*
         * 스택에 남은 것이 있다면 seq[i] 값보다 작은 값이 없으므로 -1 세팅
         */
        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            sb.append(seq[i]).append(" ");
        }
        sb.append(seq[n - 1]);

        System.out.println(sb);
        br.close();
    }
}
