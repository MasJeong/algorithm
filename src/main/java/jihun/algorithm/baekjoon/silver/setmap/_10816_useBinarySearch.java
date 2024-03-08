package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자카드2 - 집합과 맵
 */
public class _10816_useBinarySearch {

    private static int lowerBoundBinarySearch(int[] target, int targetNum) {
        int left = 0;
        int right = target.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(targetNum <= target[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int upperBoundBinarySearch(int[] target, int targetNum) {
        int left = 0;
        int right = target.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(targetNum >= target[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
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

        while(m-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            int idx1 = lowerBoundBinarySearch(target, num);
            int idx2 = upperBoundBinarySearch(target, num);

            sb.append(idx2 - idx1).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
