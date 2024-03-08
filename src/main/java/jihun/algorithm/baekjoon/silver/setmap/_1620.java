package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 나는야 포켓몬 마스터 - 집합과 맵
 * 1) NumberFormatException을 활용하여 숫자와 문자열을 구분함.
 * 2) 입력받은 문자열의 첫 번째 자리 문자의 숫자 아스키코드 값을 체크하여 구분함. - 성능 더 좋음
 */
public class _1620 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        /*
            n번 줄까지 도감.
            n번 이후 m번 부터 숫자는 n번째(1부터) 문자열, 문자열은 숫자를 출력
         */

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> mapSearch = new HashMap<>();
        HashMap<String, Integer> mapReverse = new HashMap<>();

        // 입력
        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            mapSearch.put(i, str);
            mapReverse.put(str, i);
        }

        while(m-- > 0) {
            boolean isNumber = false;
            String input = br.readLine();

            // exception을 통한 숫자 타입 문자열인지 체크 - 105224KB, 808ms
//            try {
//                Integer.parseInt(input);
//                isNumber = true;
//            } catch (NumberFormatException ex) {
//                isNumber = false;
//            }

            // 첫 번째 자릿수를 통한 숫자 타입 문자열인지 체크 - 59164KB, 600ms
            char chNum = input.charAt(0);

            // 0 ~ 9 -> 48 ~ 57
            if(chNum >= 49 && chNum <= 57) {
                isNumber = true;
            }

            if(isNumber) {
                sb.append(mapSearch.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(mapReverse.get(input)).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }

}
