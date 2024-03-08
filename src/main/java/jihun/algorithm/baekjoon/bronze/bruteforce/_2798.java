package jihun.algorithm.baekjoon.bronze.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class _2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arrCard = new int[n];
        int max = -1;
        int result = 0;

        int idx = 0;
        while(st.hasMoreTokens()) {
            arrCard[idx++] = Integer.parseInt(st.nextToken());
        }

        outer:
        for(int i = 0; i < arrCard.length -2; i++)
            for(int j = i + 1; j < arrCard.length - 1; j++)
                for(int k = j + 1; k < arrCard.length; k++) {
                    result = arrCard[i] + arrCard[j] + arrCard[k];

                    if(result == m) {
                        max = result;
                        break outer;
                    } else if(result < m) {
                        if(max < result)
                            max = result;
                    }
                }

        br.close();
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
