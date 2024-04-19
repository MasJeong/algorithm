package jihun.algorithm.baekjoon.silver.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * TODO 마인크래프트- 브루트 포스
 */
public class _18111 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        br.close();
    }
}
