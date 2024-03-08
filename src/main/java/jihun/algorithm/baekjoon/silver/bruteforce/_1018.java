package jihun.algorithm.baekjoon.silver.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * TODO 다시풀기 체스판 다시 칠하기 - 브루트 포스
 */
public class _1018 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[row][col];

        // 입력
        for(int i = 0; i < row; i++) {
            String input = br.readLine();
            for(int j = 0; j < col; j++)
                // White TRUE, Black FALSE
                if(input.charAt(j) == 'W')
                    board[i][j] = true;
        }

        // 8 * 8 로 for문 계속 돌아서 잘못된 갯수가 작은 경우를 출력
        int result = 64;
        for(int i = 0; i < row - 7; i++)
            for(int j = 0; j < col - 7; j++) {
                // 첫 번째 칸 색
                boolean firstBoard = board[i][j];
                int cnt = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int n = j; n < j + 8; n++) {
                        if (board[k][n] != firstBoard)
                            cnt++;

                        firstBoard = (!firstBoard);
                    }

                    firstBoard = (!firstBoard);
                }

                cnt = Math.min(cnt, 64 - cnt);
                result = Math.min(result, cnt);
            }

        br.close();
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
