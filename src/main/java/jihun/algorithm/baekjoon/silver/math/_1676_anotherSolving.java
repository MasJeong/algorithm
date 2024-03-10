package jihun.algorithm.baekjoon.silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼 0의 개수 - 수학
 */
public class _1676_anotherSolving {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        System.out.println(count);
    }

}