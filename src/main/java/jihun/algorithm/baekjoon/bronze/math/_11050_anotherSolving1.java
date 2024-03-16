package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항 계수1 - 수학(조합론)
 */
public class _11050_anotherSolving1 {

    private static int factorial(int num) {
        if (num == 0) return 1;

        return num * factorial(num - 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // nCr = n! / (n - r)! * r!
        System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
        br.close();
    }

}
