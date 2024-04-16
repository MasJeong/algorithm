package jihun.algorithm.baekjoon.bronze.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15829 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final int NUMBER = 31;

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // TODO 빅인티저나 long형 초과 시 m으로 나누거나 하자 (오버플로우 체크)
        long sum = 0L;

        for (int i = 0; i < str.length(); i++) {
            long a = str.charAt(i) - 96;

            sum += a * ((long) Math.pow(NUMBER, i));
        }

        sb.append(sum);

        System.out.println(sb);
        br.close();
    }

}
