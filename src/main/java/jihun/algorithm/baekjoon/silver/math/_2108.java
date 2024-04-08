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

        /*
        최빈값을 구하기 위한 카운팅 배열
        정수의 최댓값이 4000이기 때문에 음수처리의 경우 -1이 나오면 4001 인덱스에 삽입
         */
        final int[] arrCounting = new int[8001];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;

            if (input >= 0) {
                arrCounting[input]++;
            } else {
                arrCounting[4000 - input]++;
            }
        }

        // 산술평균
        for (int a : arr) {
            sum += a;
        }

        sb.append(Math.round(sum / arr.length)).append("\n");

        // 중앙값
        Arrays.sort(arr);
        sb.append(arr[arr.length / 2]).append("\n");

        int max = 1;
        boolean isEqual = false;
        int idx = 0;

        // TODO 최빈값 구하는 부분 다시 구현해보자
        int[] arrMax = new int[arrCounting.length];

        for (int i = 0; i < arrCounting.length; i++) {
            if (arrCounting[i] == 0) continue;

            int cnt = 0;

            while (arrCounting[i]-- > 0) {
                cnt++;
            }

            if (cnt < max) continue;

            max = cnt;
            arrMax[idx++] = i > 4000 ? -i + 4000 : i;

            if (cnt >= 2) {
                arrMax[idx++] = i > 4000 ? -i + 4000 : i;
                isEqual = true;
            }
        }

        int[] newArr = new int[idx];
        for (int i = 0; i < idx; i++) {
            newArr[i] = arrMax[i];
        }

        Arrays.sort(newArr);

        if (isEqual) {
            sb.append(newArr[1]).append("\n");
        } else {
            sb.append(newArr[0]).append("\n");
        }

        // 범위
        int range = 0;
        int range1 = arr[arr.length - 1] - arr[0];
        int range2 = arr[arr.length - 1] > arr[0] ? range1 : arr[0] - arr[arr.length - 1];

        // 둘 다 양수
        if (arr[arr.length - 1] >= 0 && arr[0] >= 0) {
            range = range2;
        }
        // 최대값만 양수
        else if (arr[arr.length - 1] >= 0) {
            range = range1;
        }
        // 최솟값만 양수인 경우는 없음.
//        else if (arr[0] >= 0) {
//            range = arr[0] - arr[arr.length - 1];
//        }
        // 둘 다 음수
        else {
            range = range2;
        }

        sb.append(range);

        System.out.println(sb);
        br.close();
    }
}
