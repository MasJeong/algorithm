package jihun.algorithm.baekjoon.bronze.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int xMin = 10001;
        int xMax = -10001;
        int yMin = 10001;
        int yMax = -10001;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            xMin = Math.min(xMin, num1);
            xMax = Math.max(xMax, num1);
            yMin = Math.min(yMin, num2);
            yMax = Math.max(yMax, num2);
        }

        System.out.println((xMax - xMin) * (yMax - yMin));

        br.close();
    }
}
