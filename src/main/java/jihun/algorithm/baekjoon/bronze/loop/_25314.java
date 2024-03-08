package jihun.algorithm.baekjoon.bronze.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n/4; i++) {
            sb.append("long ");
        }

        sb.append("int");
        System.out.println(sb);
    }
}
