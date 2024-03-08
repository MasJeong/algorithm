package jihun.algorithm.baekjoon.silver.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 흰색도화지를 검정 색종이로 덮은 후 넓이 구하기
 * - 처음에는 2차원 boolean 배열을 만든 후 겹치지 않는 부분은 넓이 100
 * - 겹치는 부분은 배열의 false인 부분 인덱스부터 끝 인덱스의 값을 곱해주려고 했다.
 * -> 그러나 2차원 배열의 true인 부분들만 카운트해주면 그게 넓이다.
 */
public class _2563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] arr = new boolean[101][101];
        int n = Integer.parseInt(br.readLine());
        int area = 0;

        for(int i = 0; i < n; i++) {
            String[] arrInput = br.readLine().split(" ");
            int num1 = Integer.parseInt(arrInput[0]);
            int num2 = Integer.parseInt(arrInput[1]);

            for(int j = num1; j < num1 + 10; j++)
                for(int k = num2; k < num2 + 10; k++)
                    if(!arr[j][k]) {
                        arr[j][k] = true;
                        area++;
                    }
        }

        System.out.println(area);
    }
}
