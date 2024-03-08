package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 대칭차집합 - 집합과 맵
 * - map을 각각 2개씩 만들어 풀었지만 메모리 낭비가 과하므로 좋지 않을 것 같다.
 */
public class _1269 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapA2 = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        HashMap<Integer, Integer> mapB2 = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            int input = Integer.parseInt(st.nextToken());
            mapA.put(n, input);
            mapA2.put(input, n);
        }

        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int input = Integer.parseInt(st.nextToken());
            mapB.put(input, m);
            mapB2.put(m, input);
        }

        int answer = 0;

        // A - B
        for(int i = 0; i < mapA.size(); i++) {
            if (!mapB.containsKey(mapA.get(i))) answer++;
        }

        // B - A
        for(int i = 0; i < mapB2.size(); i++) {
            if (!mapA2.containsKey(mapB2.get(i))) answer++;
        }

        System.out.println(answer);

        br.close();
    }

}
