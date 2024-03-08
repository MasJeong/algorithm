package jihun.algorithm.baekjoon.bronze.loop;

import java.io.*;
import java.util.StringTokenizer;

public class _2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int total = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            total += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }
        if(X == total)
            bw.write("Yes");
        else
            bw.write("No");

        br.close();

        bw.flush();
        bw.close();
    }
}
