package jihun.algorithm.baekjoon.bronze.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        br.close();
        bw.write(Integer.toString(arr[n - k]));
        bw.flush();
        bw.close();
    }
}
