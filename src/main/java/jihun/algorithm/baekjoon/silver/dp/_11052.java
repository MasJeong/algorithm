package jihun.algorithm.baekjoon.silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드 구매하기 - dp TODO 진행예정
 */
public class _11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }



        System.out.println(sb);
        br.close();
    }
}
