package jihun.algorithm.baekjoon.bronze.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 공 바꾸기
 */
public class _10813 {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for(int idx = 0; idx < m; idx++) {
            StringTokenizer stLine = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stLine.nextToken()) - 1;
            int j = Integer.parseInt(stLine.nextToken()) - 1;

            swap(arr, i, j);
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
