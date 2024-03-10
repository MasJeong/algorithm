package jihun.algorithm.baekjoon.silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드바흐의 추측 - 수학 소수
 */
public class _6588_anotherSolving {

    static final int MAX_LENGTH = 1000001;
    static boolean[] prime = new boolean[MAX_LENGTH];
    static int[] answer = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // false: 소수
        prime[0] = prime[1] = true;

        // 에라토스테네스의 체 적용
        for (int i = 2; i <= Math.sqrt(MAX_LENGTH); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        while (n != 0) {
            boolean isPass = false;

            for (int i = 3; i <= n; i++) {
                if(!prime[i] && !prime[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    isPass = true;
                    break;
                }
            }

            if (!isPass) {
                System.out.println("Goldbach's conjecture is wrong.");
                continue;
            }

            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
        br.close();
    }

}
