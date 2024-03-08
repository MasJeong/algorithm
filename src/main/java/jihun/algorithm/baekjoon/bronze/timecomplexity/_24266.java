package jihun.algorithm.baekjoon.bronze.timecomplexity;

import java.io.*;

/**
 * 시간복잡도 5번
 */
public class _24266 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());

        br.close();
        bw.write((n * n * n) + "\n" + 3);
        bw.flush();
        bw.close();
    }

}
