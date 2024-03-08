package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 숫자카드 - 집합과 맵
 * 방법 1) HashMap 2개를 생성하여 키값 조회 - 메모리 185.488MB, 시간 1012ms
 * 방법 2) 정렬 후 이분탐색을 사용 - 메모리 103.272MB, 시간 1260ms
 */
public class _10815 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> mapN = new HashMap<Integer, Integer>();

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            mapN.put(Integer.parseInt(st.nextToken()), i);
        }

        int m = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> mapM = new HashMap<Integer, Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            mapM.put(i, Integer.parseInt(st.nextToken()));
        }

        int[] result = new int[m];

        for(int i = 0; i < m; i++) {
            if(mapN.containsKey(mapM.get(i))) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            sb.append(result[i])
                    .append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
