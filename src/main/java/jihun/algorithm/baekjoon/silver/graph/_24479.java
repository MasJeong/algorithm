package jihun.algorithm.baekjoon.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 알고리즘 수업 - 깊이 우선 탐색 1
 */
public class _24479 {

    static int[][] arr;
    static boolean[] visited;
    static int cntNode;
    static int cntEdge;
    static int startNodeNum;
    static StringBuilder sb;
    static final Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    private static void dfs(int start) {
        stack.add(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if(visited[node]) continue;

            visited[node] = true;
            sb.append(node).append("\n");

            // 인접 노드를 역순으로 스택에 추가
            for (int i = 0; i < list.get(node).size(); i++) {
                int next = list.get(node).get(i);

                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        cntNode = Integer.parseInt(st.nextToken());
        cntEdge = Integer.parseInt(st.nextToken());
        startNodeNum = Integer.parseInt(st.nextToken());

//        arr = new int[cntNode + 1][cntNode + 1];
        // 그래프 초기화
        for (int i = 0; i <= cntNode; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[cntNode + 1];

        for (int i = 0; i < cntEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 입력 시 인접행렬 표현
//            arr[a][b] = arr[b][a] = 1;

            // 인접리스트 표현
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 정렬
        for(int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }

        dfs(startNodeNum);

        for (int i = 1; i < visited.length; i++) {
            if(visited[i]) continue;

            sb.append(0).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
