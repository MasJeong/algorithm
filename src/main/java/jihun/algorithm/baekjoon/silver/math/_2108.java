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
        정수의 최댓값이 4000이기 때문에 음수처리의 경우 -1이 나오면 4000 + 1.
        최빈값을 구하기 위한 카운팅 배열
         */
        final int[] arrCounting = new int[8001];
        float sum = 0;

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

        int max = 0;    // 많이 나타난 횟수
        int value = 0;  // 가장 많이 나타난 값
        boolean isEqual = false;    // 동일한 횟수가 나온 경우 true
        int[] arrMin = new int[8001];  // 최빈값 저장 배열

        // 가장 많이 나타난 값을 찾는다.
        int idx = 0;

        // 처음 나타난 값의 카운트를 세팅한다.
        for (int i = arrCounting.length - 1; i >= 0; i--) {
            if (arrCounting[i] == 0) continue;

            int a = arrCounting[i];

            while (a-- > 0) {
                max++;
            }

            break;
        }

        for (int i = arrCounting.length - 1; i >= 0; i--) {
            if (arrCounting[i] == 0) continue;

            int cnt = 0;

            while (arrCounting[i]-- > 0) {
                cnt++;
            }

            if (max < cnt) {
                value = i;
                max = cnt;
            }
            // 가장 많이 나타나는 값이 중복되는 경우
            else if (max == cnt) {
                arrMin[idx++] = i > 4000 ? -i + 4000 : i;

                isEqual = true;
            }
        }

        int[] arrMin2 = new int[idx];  // 최빈값 저장 배열2
        for (int i = 0; i < arrMin2.length; i++) {
            arrMin2[i] = arrMin[i];
        }

        Arrays.sort(arrMin2);

        // 동일한 횟수가 나온 경우 두 번째로 작은 값을 찾는다.
        if (isEqual && arrMin2.length > 1) {
            sb.append(arrMin2[1]).append("\n");
        } else {
            sb.append(value == 0 ? arrMin[0] : value).append("\n");
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
//        else if (twoPlus) {
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
