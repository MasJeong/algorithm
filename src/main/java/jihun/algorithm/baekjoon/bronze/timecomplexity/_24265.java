package jihun.algorithm.baekjoon.bronze.timecomplexity;

import java.io.*;

/**
 * 시간복잡도 4번
 */
public class _24265 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
//        int cnt = 0;

        /**
         * ex) n = 7
         * i = 1, j = 2 ~ 7 (6번)
         * i = 2, j = 3 ~ 7 (5번)
         * i = 3, j = 4 ~ 7 (4번)
         * i = 4, j = 5 ~ 7 (3번)
         * i = 5, j = 6 ~ 7 (2번)
         * i = 6, j = 7 (1번)
         */
//        for(int i = 1; i <= n - 1; i++)
//            for(int j = i + 1; j <= n; j++)
//                cnt++;
//        System.out.println(cnt);

        br.close();
        // 등차수열 합 공식 = n(n+1)/2
        // 반복횟수 i는 n - 1이므로 (n-1)(n-1+1)/2 = n^2-n/2
        bw.write(n * (n - 1) / 2 + "\n" + 2);
        bw.flush();
        bw.close();
    }

}
