package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배수와 약수 - 수학
 */
public class _5086 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();


        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String result = null;

            if(a == 0 && b == 0) break;

            // 첫 번째 숫자가 두 번째 숫자의 약수인 경우
            if(b % a == 0) {
                result = "factor";
            } else if(a % b == 0) {
                result = "multiple";
            } else {
                result = "neither";
            }

            sb.append(result).append("\n");

        }

        System.out.println(sb);

        br.close();
    }

}
