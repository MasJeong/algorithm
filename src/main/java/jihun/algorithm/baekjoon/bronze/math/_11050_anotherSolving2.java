package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항 계수1 - 수학(조합론)
 * Binomial Coefficient
 */
public class _11050_anotherSolving2 {

    private static Integer[][] dp;

    private static int binomial(int n, int k) {
        if (dp[n][k] != null) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = binomial(n - 1, k - 1) + binomial(n - 1, k);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new Integer[n + 1][k + 1];

        System.out.println(binomial(n, k));
        br.close();
    }

}
