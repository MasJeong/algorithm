package jihun.algorithm.baekjoon.silver.greedy;

import java.io.*;

/**
 * 설탕배달
 * 그리디 알고리즘이란
 * - 선택의 순간마다 당장 눈 앞에 보이는 최적의 상황을 쫓아 최적해를 구하는 알고리즘
 * - 순간마다 최선을 선택했다고 하나 최종적인 해답에서 최적이라고 보장은 없다.
 * 그리디 알고리즘 적용 조건
 * 1) 앞의 선택이 이후의 선택에 영향을 주면 안된다.
 * 2) 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성된다.
 */
public class _2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(n > 0) {
            if(n % 5 == 0) {
                cnt += n / 5;
                break;
            }

            if(n < 3) {
                cnt = -1;
                break;
            }

            n -= 3;
            cnt++;
        }

        br.close();
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }
}
