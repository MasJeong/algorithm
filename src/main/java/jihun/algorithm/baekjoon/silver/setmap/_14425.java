package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 문자열 집합 - 집합과 맵
 * HashSet을 사용하여 size만 체크하려 했으나 M개의 문자열은 중복이 가능하기 때문에 반례가 존재함(ex: 1 2 a b b).
 * -> 10815번과 비슷하게 검색 map을 생성하여 찾을값으로 map을 탐색함.
 */
public class _14425 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 집합 S에 같은 문자열이 주어지지 않으므로 set 자료구조 사용할 필요없음.
        HashMap<String, Integer> mapSearch = new HashMap<String, Integer>();

        // 입력
        for(int i = 0; i < n; i++) {
            mapSearch.put(br.readLine(), i);
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            if(mapSearch.containsKey(br.readLine())) {
                count++;
            }
        }

        // 출력
        System.out.println(count);

        br.close();
    }

}
