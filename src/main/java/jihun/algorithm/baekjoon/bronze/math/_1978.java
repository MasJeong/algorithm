package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 찾기 - 수학
 */
public class _1978 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int primeCnt = 0;
        while(st.hasMoreTokens()) {
            int prime = Integer.parseInt(st.nextToken());

            if(prime < 2) continue;

            // 2부터 자신의 수까지 나머지가 0이 되는 수가 없다면 소수
            boolean isPrime = true;
            for(int i = 2; i < prime; i++) {
                if(prime % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                primeCnt++;
            }
        }

        System.out.println(primeCnt);

        br.close();
    }

}
