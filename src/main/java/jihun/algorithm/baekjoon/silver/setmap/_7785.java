package jihun.algorithm.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 회사에 있는 사람 - 집합과 맵
 */
public class _7785 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> mapUser = new HashMap<>();

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String userName = st.nextToken();
            String work = st.nextToken();

            if(mapUser.containsKey(userName)) {
                mapUser.remove(userName);
            } else {
                mapUser.put(userName, work);
            }

            // 위와 동일
//            if(work.equals("enter")) {
//                mapUser.put(userName, work);
//            } else {
//                mapUser.remove(userName);
//            }
        }

        // HashMap to List
        List<String> keySet = new ArrayList<>(mapUser.keySet());

        keySet.sort(Collections.reverseOrder());

        for(String str : keySet) {
            sb.append(str).append("\n");
        }

        // 출력
        System.out.println(sb);

        br.close();
    }

}
