package jihun.algorithm.baekjoon.silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 통계학
 */
public class _2108 {

    /**
     * 최빈값을 가져오는 메소드
     * @param arrCounting 카운팅 배열
     * @return 최빈값 정수
     */
    private static int getMode(int[] arrCounting) {
        // 등장 횟수가 이전 요소와 동일한지 판단여부
        boolean isEqual = false;
        // 최빈값을 저장할 배열의 인덱스
        int idx = 0;
        // 등장 횟수 최대값 체크용 변수
        int max = 0;

        /*
        최빈값 : N개의 수들 중 가장 많이 나타나는 값
        최빈값이 여러개인 경우 두 번째로 작은 값을 출력
         */
        int[] arrMax = new int[arrCounting.length];

        for (int i = 0; i < arrCounting.length; i++) {
            if (arrCounting[i] == 0) continue;

            int cnt = 0;

            while (arrCounting[i]-- > 0) {
                cnt++;
            }

            if (cnt < max) continue;

            if (cnt > max) {
                max = cnt;
                isEqual = false;

                // 최빈값이 새로 생긴 경우 배열 초기화
                arrMax = new int[arrCounting.length];
                idx = 0;
            } else {
                isEqual = true;
            }

            arrMax[idx++] = i > 4000 ? -i + 4000 : i;
        }

        int[] arrResult = new int[idx];
        for (int i = 0; i < idx; i++) {
            arrResult[i] = arrMax[i];
        }

        Arrays.sort(arrResult);

        if (isEqual && arrMax.length > 1) {
            return arrResult[1];
        } else {
            return arrResult[0];
        }
    }

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

        // 입력
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

        // 최빈값
        sb.append(getMode(arrCounting)).append("\n");

        // 범위
        int range;
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
        // 둘 다 음수
        else {
            range = range2;
        }

        sb.append(range);

        System.out.println(sb);
        br.close();
    }

}
