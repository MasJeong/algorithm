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

        final int MAX_HEIGHT = 257;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arrCraft = new int[n][m];
        int maxHeight = -1;
        int minTime = 64000001 * 2;

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arrCraft[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < MAX_HEIGHT; i++) {
            // 반복문 종료 조건
            boolean isFinish = true;
            int time = 0;
            int invenCnt = b;

            outer:
            for(int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int tempHeight = arrCraft[j][k];

                    if (i == tempHeight) continue;

                    // 블록으로 땅을 채워야 하는 경우 (1초)
                    if (i > tempHeight) {
                        while (i != tempHeight) {
                            if(invenCnt == 0) {
                                isFinish = false;
                                break outer;
                            }

                            tempHeight++;
                            time++;
                            invenCnt--;
                        }
                    }
                    // 땅 블록을 회수해야 하는 경우 (2초)
                    else {
                        while (i != tempHeight) {
                            time += 2;
                            invenCnt++;
                            tempHeight--;
                        }
                    }
                }
            }

            // 가장 바깥 반복문 종료 조건
            if (isFinish && (minTime > time)) {
                maxHeight = Math.max(i, maxHeight);
                minTime = time;
            }
        }

        System.out.println(minTime + " " + maxHeight);
        br.close();
    }
}
