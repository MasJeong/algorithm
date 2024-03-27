package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
            PriorityQueue<Printer> pq = new PriorityQueue<>(100, new Printer());

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arrPriority = new int[n];

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                pq.offer(new Printer(i, num));
                arrPriority[i] = num;
            }

//            for (int i = 0; i < n; i++) {
//                while (!priorityQueue.isEmpty() &&  priorityQueue.peek().priority < arrPriority[i]) {
//                    priorityQueue.offer(priorityQueue.poll());
//                }
//            }

            for (int i = 0; i < n; i++) {
//                Printer pr = pq.poll();

                if (pq.poll().idx == m) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }

            pq.clear();
        }

        System.out.println(sb);
        br.close();
    }
}
