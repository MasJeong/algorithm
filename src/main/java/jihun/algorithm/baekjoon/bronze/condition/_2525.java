package jihun.algorithm.baekjoon.bronze.condition;

import java.io.*;
import java.util.StringTokenizer;

public class _2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int t = a;
        int m = b + c;

        if(m >= 60) {
            t += m / 60;
            m = m % 60;
        }

        if(t >= 24)
            t -= 24;

        br.close();
        bw.write(t + " " + m);
        bw.flush();
        bw.close();
    }
}
