package jihun.algorithm.baekjoon.bronze.array;

import java.io.*;
import java.util.StringTokenizer;

public class _10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int find = 0;
        int cnt = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            if(find == arr[i]) {
                cnt++;
            }
        }

        br.close();
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }
}
