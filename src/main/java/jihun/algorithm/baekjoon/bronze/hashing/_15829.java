package jihun.algorithm.baekjoon.bronze.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15829 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final int NUMBER = 31;
        final long M = 1234567891;

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0L;

        // TODO 이거 pow 연산부터 오버플로우 발생하기 때문에 직접 수계산을 하는 방식으로 진행해야 할듯.
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - 96) * ((long) Math.pow(NUMBER, i));
        }

        sb.append(sum % M);

        System.out.println(sb);
        br.close();
    }

}
