package jihun.algorithm.baekjoon.silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 통계학
 */
public class _2108 {

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        final int[] arr = new int[n];

        // 정수의 최댓값이 4000이기 때문에 -1이 나오면 4000 + 1 해줄거임.
        final int[] arrCounting = new int[8001];
        int sum = 0;
        int avg = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;

            if (input > 0) {
                arrCounting[input]++;
            } else {
                arrCounting[4000 - input]++;
            }
        }

        // 산술평균
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        sb.append(Math.round((float) (sum / arr.length))).append("\n");

        // 중앙값
        Arrays.sort(arr);
        sb.append(arr[arr.length / 2]).append("\n");

        int max = 0;
        // 최빈값이 여러 개 나타나는지 확인용
        boolean isEqual = false;
        int countTwice = 0;

        // 최빈값
        int min = 0;
        int idx = 0;

        for (int i = arrCounting.length - 1; i >= 0 ; i--) {
            if (arrCounting[i] == 0) continue;

            int cnt = 0;

            while (arrCounting[i]-- > 0) {
                cnt++;
            }

            if (max < cnt) {
                idx = i;
                max = cnt;
            }
            // 가장 많이 나타나는 값이 중복되는 경우
            else if (cnt != 0 && max == cnt) {
                countTwice++;
                isEqual = true;
            }

            if (isEqual && countTwice == 2) {
                min = i > 4000 ? i - 4000 : i;
                break;
            }
        }

        if (isEqual) {
            sb.append(min).append("\n");
        } else {
            sb.append(idx).append("\n");
        }

        // TODO 절대값 계산 추가해야 함
        sb.append(arr[arr.length - 1] - arr[0]);

        System.out.println(sb);
        br.close();
    }

}
