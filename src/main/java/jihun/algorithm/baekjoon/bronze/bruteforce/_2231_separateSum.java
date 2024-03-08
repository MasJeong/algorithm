package jihun.algorithm.baekjoon.bronze.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분해합 - 숫자의 한자리씩 char로 뜯어내어 비교한 방법
 * 자연수 245(n)의 분해합은 256(2+4+5)(m)
 */
public class _2231_separateSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 1;

        while(n > num) {
            String str = Integer.toString(num);
            int temp = num++;

            for(int i = 0 ; i < str.length(); i++) {
                int a = str.charAt(i) - '0';
                temp += a;
            }

            if(n == temp) {
                break;
            }
        }

        if(n == num) {
            System.out.println(0);
        } else {
            System.out.println(num - 1);
        }

        br.close();
    }
}
