package jihun.algorithm.baekjoon.bronze.geometry;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arrInput = {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };

            if(arrInput[0] == 0 && arrInput[1] == 0 && arrInput[2] == 0)
                break;

            Arrays.sort(arrInput);

            if(arrInput[0] + arrInput[1] <= arrInput[2])
                bw.write("Invalid");
            else if(arrInput[0] == arrInput[1] && arrInput[1] == arrInput[2])
                bw.write("Equilateral");
            else if(arrInput[0] == arrInput[1] || arrInput[1] == arrInput[2] || arrInput[0] == arrInput[2])
                bw.write("Isosceles");
            else
                bw.write("Scalene");

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
