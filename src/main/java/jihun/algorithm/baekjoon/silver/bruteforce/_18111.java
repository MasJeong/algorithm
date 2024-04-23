package jihun.algorithm.baekjoon.silver.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마인크래프트- 브루트 포스
 */
public class _18111 {

//    /**
//     * 가장 많이 나온 높이 값을 반환한다.
//     * @param arrCounting 카운팅 배열
//     * @return 최고 높이값
//     */
//    private static int getMaxCountHeight(int[] arrCounting) {
//        int maxCountHeight = -1;
//        int idx = -1;
//
//        for (int i = 0; i < arrCounting.length; i++) {
//            if (arrCounting[i] == 0) continue;
//
//            int tempCount = 0;
//            while (arrCounting[i]-- > 0) {
//                tempCount++;
//            }
//
//            if (tempCount > maxCountHeight) {
//                maxCountHeight = tempCount;
//                idx = i;
//            }
//        }
//
//        if (idx == -1) {
//            throw new IllegalStateException("index error");
//        }
//
//        return idx;
//    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX_HEIGHT = 257;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arrCraft = new int[n][m];
        String answer = null;

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arrCraft[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // TODO 작업중
        for (int i = 0; i < MAX_HEIGHT; i++) {
            // 반복문 종료 조건
            boolean isFinish = true;
            int time = 0;
            int invenCnt = b;

            outer:
            for(int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (i == arrCraft[j][k]) continue;

                    // 블록으로 땅을 채워야 하는 경우 (1초)
                    if (i > arrCraft[j][k]) {
                        while (i != arrCraft[j][k]) {
                            if(invenCnt == 0) {
                                isFinish = false;
                                break outer;
                            }

                            time++;
                            invenCnt--;
                        }
                    }
                    // 땅 블록을 회수해야 하는 경우 (2초)
                    else {
                        time += 2;
                        invenCnt++;
                    }
                }
            }

            // 가장 바깥 반복문 종료 조건
            if (isFinish) {
                answer = time + " " + i;
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
