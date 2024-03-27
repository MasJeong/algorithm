package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1966_retry {

    private static class Printer {
        int idx;
        int priority;

        public Printer(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            final Queue<Printer> priorityQueue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            // 원소 삽입
            for (int i = 0; i < n; i++) {
                priorityQueue.offer(new Printer(i, Integer.parseInt(st.nextToken())));
            }

            // 우선순위 정렬
            final Printer pollElement = priorityQueue.poll();

            /*
            TODO 이부분 다시 확인하기
            1 2 3 4
            2 3 4 1
            3 4 1 2
            4 1 2 3

            1 3 4 2
            3 4 2 1
            4 2 1 3
            4 2 3 1
             */
            int a = n;
            while (a-- > 0) {
                while (!priorityQueue.isEmpty() && pollElement.priority < priorityQueue.peek().priority) {
                    priorityQueue.offer(pollElement);
                }
            }

            for (int i = 1; i <= n; i++) {
                if (priorityQueue.poll().idx == m) {
                    sb.append(i).append("\n");
                    break;
                }
            }

            priorityQueue.clear();
        }

        System.out.println(sb);
        br.close();
    }
}
