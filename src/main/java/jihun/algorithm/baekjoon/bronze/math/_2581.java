package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소수 - 수학
 */
public class _2581 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;

        for(int i = m; i <= n; i++) {
            int cnt = 0;
            for(int j = 2; j <= i; j++) {
                if(i % j == 0) {
                    cnt++;
                }
            }

            if(cnt == 1) {
                sum += i;

                if(min == 0) {
                    min = i;
                }
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum + "\n" + min);
        }

        br.close();
    }

}
