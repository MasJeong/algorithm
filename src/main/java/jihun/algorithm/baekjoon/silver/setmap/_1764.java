package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 듣보잡 - 집합과 맵
 */
public class _1764 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        HashMap<String, Integer> mapSearch = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while(n-- > 0) {
            mapSearch.put(br.readLine(), n);
        }

        // 문자열 찾기
        String[] result = new String[m];
        int idx = 0;
        while (m-- > 0) {
            String str = br.readLine();
            Integer i = mapSearch.get(str);

            if(i != null) {
                result[idx++] = str;
            }
        }

        String[] result2 = new String[idx];
        for(int i = 0; i < result2.length; i++) {
            if(result[i] == null) break;

            result2[i] = result[i];
        }

        Arrays.sort(result2);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(result2.length).append("\n");
        for (String s : result2) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
