package jihun.algorithm.baekjoon.bronze.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분해합 - 10으로 나눈 나머지로 각 자릿수를 더하는 방식.
 * 자연수 245(n)의 분해합은 256(2+4+5)(m)
 */
public class _2231_separateSum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 1; i < n; i++) {
            int sum = i;
            int mok = i;

            while (mok > 0) {
                sum += mok % 10;
                mok /= 10;
            }

            if (n == sum) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }
}
