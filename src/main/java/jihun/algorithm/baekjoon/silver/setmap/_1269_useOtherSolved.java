package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 대칭차집합 - 집합과 맵
 * - 이전에 map을 각각 2개씩 만들어 풀긴하였지만 메모리 낭비가 과하므로 좋지 않을 것 같다.
 * -> HashSet contains(O(1)) 메소드를 사용하여 풀었다.
 */
public class _1269_useOtherSolved {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        HashSet<Integer> hashSetA = new HashSet<>();
        HashSet<Integer> hashSetB = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            hashSetA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            hashSetB.add(Integer.parseInt(st.nextToken()));
        }

        int resultCnt = 0;

        // A - B
        for(Integer i : hashSetA) {
            // HashSet의 contains 메소드는 O(1)
            if (!hashSetB.contains(i)) resultCnt++;
        }

        // B - A
        for(Integer i : hashSetB) {
            if (!hashSetA.contains(i)) resultCnt++;
        }

        System.out.println(resultCnt);

        br.close();
    }

}
