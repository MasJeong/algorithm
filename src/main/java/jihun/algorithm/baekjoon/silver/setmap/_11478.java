package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 서로 다른 부분 문자열 개수 - 집합과 맵
 */
public class _11478 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String input = br.readLine();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            int idx = i + 1;
            set.add(input.substring(i, i + 1));

            while (idx < input.length()) {
                set.add(input.substring(i, idx + 1));

                idx++;
            }
        }

        System.out.println(set.size());

        br.close();
    }

}
