package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자카드2 - 집합과 맵
 * - 이분정렬을 이용한 lower, upperBound 조건에 애를 먹었음...
 */
public class _10816_useBinarySearchRetry {

    /**
     * 중복된 숫자가 존재하는 경우 맨 앞 index를 반환한다.
     * @param target 정렬된 배열
     * @param targetNum 찾을 수
     * @return 맨앞 index
     */
    private static int lowerBoundBinarySearch(int[] target, int targetNum) {
        int left = 0;
        int right = target.length;

        // 하한은 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
        while(left < right) {
            int mid = (left + right) / 2;

            if(targetNum <= target[mid]) {
                // 하한에서 값을 찾았으니 right를 줄이면 mid가 줄테니 동일한 값이 없다면
                // 아래 left 를 mid1 증가시켜 while을 종료한다.
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 중복된 수가 존재하는 경우 맨 뒤 index를 반환한다.
     * @param target 정렬된 배열
     * @param targetNum 찾을 수
     * @return 맨뒤 index
     */
    private static int upperBoundBinarySearch(int[] target, int targetNum) {
        int left = 0;
        int right = target.length;

        // 상한은 찾고자 하는 값을 초과한 값을 처음 만나는 위치
        while(left < right) {
            int mid = (left + right) / 2;

            if (targetNum < target[mid]) {
                // 상한에서 값이 초과하였으니 right를 줄이면 mid가 줄테니 동일한 값이 없다면
                // 아래 left 를 mid1 증가시켜 while을 종료한다.
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            target[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(target);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        // 이분탐색
        while(m-- > 0) {
            int targetNum = Integer.parseInt(st.nextToken());
            int left = lowerBoundBinarySearch(target, targetNum);
            int right = upperBoundBinarySearch(target, targetNum);

            sb.append(right - left).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
