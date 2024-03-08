package jihun.algorithm.baekjoon.bronze.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 연립방정식 풀이는 아래와 같다.
 * ax + by = c
 * dx + ey = f
 * 1) adx + bdy = cd
 *    adx + aey = af (x를 뺸다)
 * 2) bdy - aey = cd - af
 *    (bd - ae)y = cd - af
 *    y = (cd - af) / (bd - ae)
 * x는 y와 같이 구한다.
 *    x = (ce - bf) / (ae - bd)
 */
public class _19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        Loop1:
        for(int i = -999; i <= 999; i++)
            Loop2:
            for(int j = -999; j <= 999; j++)
                if((a * i + b * j == c) && (d * i + e * j == f)) {
                    bw.write(i + " " + j);
                    break Loop1;
                }

        br.close();
        bw.flush();
        bw.close();
    }

}
