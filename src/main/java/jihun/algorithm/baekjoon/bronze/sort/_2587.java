package jihun.algorithm.baekjoon.bronze.sort;

import java.io.*;

public class _2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        int[] counting = new int[100];
        int sum = 0;
        int idx = 0;

        // input
        for(int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(br.readLine());
            counting[num]++;
            sum += num;
        }

        // counting sort
        for(int i = 0; i < counting.length; i++)
            while(counting[i]-- > 0)
                arr[idx++] = i;


        br.close();
        bw.write(Integer.toString(sum / 5) + "\n" + arr[2]);
        bw.flush();
        bw.close();
    }
}
