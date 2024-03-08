package jihun.algorithm.baekjoon.silver.bruteforce;

import java.io.*;

public class _1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int result = 666;

        // 찾을 값에 666이 포함되어 있는지 666부터 1씩 증가시키며 찾는다
        while(n != cnt) {
            result++;

            if(Integer.toString(result).contains("666")) {
                cnt++;
            }
        }

        br.close();
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
