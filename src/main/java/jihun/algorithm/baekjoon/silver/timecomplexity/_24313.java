package jihun.algorithm.baekjoon.silver.timecomplexity;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 시간복잡도 7번
 */
public class _24313 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
            f(n) = a1 * n + a0
            f(n) = 7n + 7, g(n) = n, c = 8, n0 = 1이다. f(1) = 14, c × g(1) = 8이므로 O(n) 정의를 만족하지 못한다.
            f(n) = 7n + 7, g(n) = n, c = 8, n0 = 10이다. 모든 n ≥ 10에 대하여 7n + 7 ≤ 8n 이므로 O(n) 정의를 만족한다.
         */
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        int n = n0;
        int result = 1;

        while(n <= 100) {
            int fn = a1 * n + a0;
            int gn = c * n++;

            if(fn > gn) {
                result = 0;
                break;
            }
        }

        br.close();
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

}
