package jihun.algorithm.baekjoon.bronze.timecomplexity;

import java.io.*;

/**
 * 시간복잡도 6번
 */
public class _24267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());

        /**
         * ex) n = 7
         * i = 1, j = 2, k = 3 ~ 7 (5번)
         *        j = 3, k = 4 ~ 7 (4번)
         *        j = 4, k = 5 ~ 7 (3번)
         *        j = 5, k = 6 ~ 7 (2번)
         *        j = 6, k = 7 (1번)
         *
         * 등식을 만들지 못했다
         * 1부터 n까지의 숫자중 3가지(i, j, k)를 뽑아 중복없이 크기 순으로 작성하는 경우의 수가 수행횟수.
         * => nCr = n! / (n-r)! * r!    n은 최대 갯수, r은 뽑는 숫자 갯수 (이 공식은 확률과 통계-조합)
         * => 7C3 = (7 * 6 * 5 * 4 * 3 * 2 * 1) / (4 * 3 * 2 * 1) * (3 * 2 * 1)
         * => 210 / 6 = 35
         * (n * (n-1) * (n-2)) / 6 => 최고차항은 3
         */

        br.close();
        bw.write((n * (n-1) * (n-2)) / 6 + "\n" + 3);
        bw.flush();
        bw.close();
    }

}
