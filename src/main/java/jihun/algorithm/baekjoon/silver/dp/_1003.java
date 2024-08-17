package jihun.algorithm.baekjoon.silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 함수 - DP
 */
public class _1003 {

    static Integer[] dp = new Integer[41];
    static int cntZero = 0;
    static int cntOne = 0;

    static int fibonacci(int n) {

        if (n == 0) {
            cntZero++;
            return 0;
        }

        if (n == 1) {
            cntOne++;
            return 1;
        }

        if(dp[n] != null) {
            return dp[n];
        }

        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            fibonacci(n);
            sb.append(cntZero).append(" ").append(cntOne).append("\n");

            // 카운트 변수 초기화
            cntZero = 0;
            cntOne = 0;
        }

        System.out.println(sb);
        br.close();
    }
}
