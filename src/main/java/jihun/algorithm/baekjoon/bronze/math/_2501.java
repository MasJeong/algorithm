package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 약수 구하기 - 수학
 */
public class _2501 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                cnt++;
            }

            if(cnt == k) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }

}
