package jihun.algorithm.baekjoon.bronze.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N-퍼즐
 */
public class _3041 {

    /*
    [ 각 문자 - 'A' 값 ]
    A: 0
    B: 1
    C: 2
    ...
    O: 14

    0,0   0,1   0,2   0,3   -  0    1    2    3
    1,0   1,1   1,2   1,3   -  4    5    6    7
    2,0   2,1   2,2   2,3   -  8    9    10   11
    3,0   3,1   3,2   3,3   -  12   13   14  .
          (원래 위치)                (현재 위치)
     */
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