package jihun.algorithm.baekjoon.bronze.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 공 넣기
 */
public class _10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int idx = 0; idx < m; idx++) {
            StringTokenizer stLine = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stLine.nextToken()) - 1;
            int j = Integer.parseInt(stLine.nextToken());
            int k = Integer.parseInt(stLine.nextToken());

            for(; i < j; i++) {
                arr[i] = k;
            }
        }

        for(int i = 0; i < arr.length - 1; i++) {
            bw.write(arr[i] + " ");
        }

        br.close();
        bw.write(Integer.toString(arr[arr.length - 1]));
        bw.flush();
        bw.close();
    }
}
