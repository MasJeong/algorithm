package jihun.algorithm.baekjoon.init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단오르기 - DP
 */
public class _2579 {

    static Integer[] dp;

    static int getScore(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(getScore(n - 1), getScore(n - 2));
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        dp  = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        getScore(n);

        System.out.println(sb);
        br.close();
    }

}