package jihun.algorithm.baekjoon.silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 징검다리 - 수학 및 이분탐색
 * 등차수열의 합 (N * (N+1)) / 2
 */
public class _11561 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // 입력
        while(t-- > 0) {
            long n = Long.parseLong(br.readLine());

            long left = 0;
            long right = 1_000_000_000L;
            long result = 0;

            while(left <= right) {
                long mid = (left + right) / 2;
                long sum = mid * (mid + 1) / 2; // 등차수열 합(n * (n + 1) / 2)

                /*
                문제 규칙 기준에서 입력 받은 값 n에 대한 등차수열의 합은 n보다 작을 수밖에 없다.
                등차수열의 합이 n보다 작을 때를 찾아 해당 값(mid)과 이전 결과값(result) 중 최댓값 출력.
                즉, n을 넘지 않는 mid(등차수열 임의 숫자(num))값을 출력한다.
                 */
                if(sum <= n) {
                    result = Math.max(mid, result);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
