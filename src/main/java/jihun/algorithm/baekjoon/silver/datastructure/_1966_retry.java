package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1966_retry {

    private static class Printer implements Comparator<Printer>  {
        int idx;
        int priority;

        // 우선순위 큐 인스턴스 생성 시 Comparator 세팅을 위한 생성자
        public Printer() {

        }

        public Printer(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public int compare(Printer o1, Printer o2) {
            return Integer.compare(o2.priority, o1.priority);
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            /*
            우선순위 큐는 힙(완전이진트리) 구조
            완전이진트리: 마지막 레벨을 제외하고 모든 레벨이 채워져 있는 형태
             */
            PriorityQueue<Printer> pq = new PriorityQueue<>(100, new Printer());
            Queue<Printer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                pq.offer(new Printer(i, num));
                queue.offer(new Printer(i, num));
            }

            int cnt = 0;

            while (!queue.isEmpty()) {
                // 뽑으려는 우선순위가 queue와 일치하지 않으면 뒤로 보낸다.
                if (queue.peek().priority != pq.peek().priority) {
                    queue.offer(queue.poll());
                }

                // 뽑으려는 우선순위가 queue와 일치하면 poll
                if (queue.peek().priority == pq.peek().priority) {
                    cnt++;
                    pq.poll();

                    if (queue.poll().idx == m) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
