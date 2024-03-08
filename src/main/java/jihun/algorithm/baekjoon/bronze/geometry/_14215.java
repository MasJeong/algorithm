package jihun.algorithm.baekjoon.bronze.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14215 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nMax = -1;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        nMax = Math.max(nMax, a);
        nMax = Math.max(nMax, b);
        nMax = Math.max(nMax, c);

        // 가장 긴 변의 길이가 다른 변의 길이의 합보다 작아야 한다
        if((a + b + c - nMax) > nMax)
            System.out.println(a + b + c);
        else
            System.out.println((a + b + c - nMax) * 2 - 1);

        br.close();
    }

}
