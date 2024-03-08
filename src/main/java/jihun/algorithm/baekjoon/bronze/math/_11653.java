package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소인수분해 - 수학
 */
public class _11653 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) return;

        StringBuilder sb = new StringBuilder();
        // 어떤 N이 두 개이상 곱셈(인수)으로 나타낼 수 있을 때 인수 중 한 개 이상은 반드시 √N보다 작거나 같음
        for(int i = 2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                sb.append(i).append('\n');
                n /= i;
            }
        }

        // for 종료 후 n이 1이 아니면 소수임
        if(n != 1) {
            sb.append(n);
        }

        System.out.println(sb);

        br.close();
    }

}
