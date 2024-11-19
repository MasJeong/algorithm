package jihun.algorithm.baekjoon.init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N-퍼즐
 */
public class _3041 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();

            for (int ii = 0; ii < 4; ii++) {
                char current = input.charAt(ii);

                if(current == '.') continue;

                int number = current - 'A';

                int targetRow = number / 4;
                int targetCol = number % 4;

                // 각 입력받은 정사각형의 위치에서 원래의 위치로 이동한다.
                answer += Math.abs(i - targetRow) + Math.abs(ii - targetCol);
            }
        }

        System.out.println(answer);
        br.close();
    }

}