package jihun.algorithm.baekjoon.silver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좌표 정렬하기1 - 정렬
 */
public class _11650 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] position = new int[n][2];

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(position, (o1, o2) -> {
            // 첫 번째 원소가 같으면 두 번째 원소 비교
            if(o1[0] == o2[0]) {
                // Integer.compare 메소드는 불필요한 것 같다.
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(position[i][0] + " " + position[i][1]).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

}
