package jihun.algorithm.baekjoon.silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 조합 0의 개수 - 수학 (조합) TODO 진행중
 */
public class _2004 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        // nCr = n! / (n-r)! * r!    n은 최대 갯수, r은 뽑는 숫자 갯수 (이 공식은 확률과 통계-조합)

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        System.out.println(count);
    }

}
