package jihun.algorithm.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼 - 수학
 */
public class _10872 {

    private static int factorial(int num) {
        if(num == 0 || num == 1) return 1;

        return num * factorial(num - 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        result += factorial(n);

        System.out.println(result);

        br.close();
    }

}
