package jihun.algorithm.baekjoon.silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 - dp
 * Bottom-Up 반복문
 */
public class _9095_anotherSolving {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
