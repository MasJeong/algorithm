package jihun.algorithm.baekjoon.silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Base Conversion - 수학
 */
public class _11576 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int ten = 0;

        // 10진수로 변환
        for (int i = 0; i < m; i++) {
            int square = m - i - 1;

            ten += (int) (Math.pow(a, square) * (Integer.parseInt(st.nextToken())));
        }

        // b진수로 변환
        while (ten > 0) {
            stack.push(ten % b);
            ten /= b;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
