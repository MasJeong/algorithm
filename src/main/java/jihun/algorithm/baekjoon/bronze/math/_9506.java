package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 약수 구하기 - 수학
 */
public class _9506 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == -1) break;

            int[] arr = new int[n / 2];
            int idx = 0;

            for(int i = 1; i <= n / 2; i++) {
                if(n % i == 0) {
                    arr[idx++] = i;
                }
            }

            int sum = 0;
            for(int i = 0; i < idx; i++) {
                sum += arr[i];
            }

            if(n == sum) {
                StringBuilder sb = new StringBuilder();
                sb.append(n + " = ");

                for(int i = 0; i < idx; i++) {
                    if(i == idx - 1) {
                        sb.append(arr[i]);
                    } else {
                        sb.append(arr[i] + " + ");
                    }
                }

                System.out.println(sb);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }

        br.close();
    }

}
