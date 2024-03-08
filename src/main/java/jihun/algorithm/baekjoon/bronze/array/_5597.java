package jihun.algorithm.baekjoon.bronze.array;

import java.io.*;

public class _5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] student = new int[31];

        for(int i=1; i<29; i++) {
            int ok = Integer.parseInt(br.readLine());
            student[ok] = 1;
        }

        for(int i=1; i<student.length; i++) {
            if(student[i]!=1)
                bw.write(Integer.toString(i) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
