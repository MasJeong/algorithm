package jihun.algorithm.baekjoon.silver.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마인크래프트- 브루트 포스
 */
public class _18111 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX_INVEN_SIZE = 64000000;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arrCraft = new int[n][m];
        int maxHeight = -1;
        int minTime = 64000001 * 2;

        // 가장 작은 값부터 큰 값까지 반복문을 돌려주기 위한 변수
        int max = -1;
        int min = 257;

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                arrCraft[i][j] = input;

                max = Math.max(input, max);
                min = Math.min(input, min);
            }
        }

        for (int i = min; i <= max; i++) {
            boolean isFail = false;
            int time = 0;
            int invenCnt = b;

            outer:
            for(int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int tempHeight = arrCraft[j][k];

                    if (i == tempHeight) continue;

                    // 인벤토리에서 블록을 꺼내어 땅을 채워야 하는 경우 (1초)
                    if (i > tempHeight) {
                        int subtraction = i - tempHeight;

                        // 인벤토리 블록 개수가 부족한 경우
                        if (invenCnt < subtraction) {
                            isFail = true;
                            break outer;
                        }

                        tempHeight += subtraction;
                        time += subtraction;
                        invenCnt -= subtraction;
                    }

                    // 땅 블록을 회수해야 하는 경우 (2초)
                    if (i < tempHeight) {
                        int addition = tempHeight - i;

                        // 인벤토리 크기보다 회수한 블록의 개수가 많은 경우
                        if (MAX_INVEN_SIZE < addition) {
                            isFail = true;
                            break outer;
                        }

                        tempHeight -= addition;
                        time += addition * 2;
                        invenCnt += addition;
                    }
                }
            }

            // 시간이 동일하게 걸리면 제일 높이가 높은 것을 출력
            if (!isFail && minTime == time) {
                maxHeight = Math.max(i, maxHeight);
            }

            // 시간이 제일 적게 걸리는 경우 시간과 높이를 세팅
            if (!isFail && minTime > time) {
                minTime = time;
                maxHeight = i;
            }
        }

        System.out.println(minTime + " " + maxHeight);
        br.close();
    }
}
