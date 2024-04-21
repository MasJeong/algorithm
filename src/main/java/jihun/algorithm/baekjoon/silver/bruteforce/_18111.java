package jihun.algorithm.baekjoon.silver.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TODO 마인크래프트- 브루트 포스
 * 카운팅배열을 통해 가장 많이 나온 값을 찾아서 진행했었는데
 * 입력된 값 1개씩 비교하면서 하는게 맞는 것 같기도 하고... 내일 다시 생각해보자
 */
public class _18111 {

    /**
     * 가장 많이 나온 높이 값을 반환한다.
     * @param arrCounting 카운팅 배열
     * @return 최고 높이값
     */
    private static int getMaxCountHeight(int[] arrCounting) {
        int maxCountHeight = -1;
        int idx = -1;

        for (int i = 0; i < arrCounting.length; i++) {
            if (arrCounting[i] == 0) continue;

            int tempCount = 0;
            while (arrCounting[i]-- > 0) {
                tempCount++;
            }

            if (tempCount > maxCountHeight) {
                maxCountHeight = tempCount;
                idx = i;
            }
        }

        if (idx == -1) {
            throw new IllegalStateException("index error");
        }

        return idx;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arrCraft = new int[n][m];

        // 땅의 높이가 제일 많이 나온 수를 체크하는 카운팅 배열
        int[] arrCounting = new int[257];

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int tempHeight = Integer.parseInt(st.nextToken());
                arrCraft[i][j] = tempHeight;
                arrCounting[tempHeight]++;
            }
        }

        // 가장 많이 나온 높이
        int maxCountHeight = getMaxCountHeight(arrCounting);

        int time = 0;
        int height = 0;
        boolean isFinish = false;

        while (!isFinish) {
            outer:
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    // 가장 많이 나온 높이보다 낮은 경우 같아질때까지 인벤토리에서 블록을 꺼내어 추가한다.
                    if (arrCraft[i][j] < maxCountHeight) {
                        int tempHeight = arrCraft[i][j];
                        while (tempHeight != maxCountHeight) {
                            // 인벤토리에 블록이 있으면 시간 +1
                            if (b > 0) {
                                b--;
                                time++;
                                tempHeight++;
                            }
                            // 인벤토리에 블록이 없으면(부족하면) 반복문 다시 돌기
                            else {
                                break outer;
                            }
                        }
                    }
                    // 가장 많이 나온 높이보다 큰 경우 높이가 같아질때까지 블록 회수
                    else if (arrCraft[i][j] > maxCountHeight) {
                        int tempHeight = arrCraft[i][j];
                        while (tempHeight != maxCountHeight) {
                            tempHeight--;
                            b++;
                            time += 2;
                        }
                    }
                }
            }

            isFinish = true;
        }

        height = maxCountHeight;

        System.out.println(time + " " + height);
        br.close();
    }
}
