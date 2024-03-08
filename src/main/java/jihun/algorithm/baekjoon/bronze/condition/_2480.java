package jihun.algorithm.baekjoon.bronze.condition;

import java.io.*;
import java.util.StringTokenizer;

public class _2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = 0;

        if(a == b && b == c)
            result = 10000 + a * 1000;
        else if(a == b)
            result = 1000 + a * 100;
        else if(b == c)
            result = 1000 + b * 100;
        else if(a == c)
            result = 1000 + a * 100;
        else if(a != b && a != c && b != c)
            if(a > b)
                if(a > c)
                    result = a * 100;
                else
                    result = c * 100;
            else
                if(b > c)
                    result = b * 100;
                else
                    result = c * 100;

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
