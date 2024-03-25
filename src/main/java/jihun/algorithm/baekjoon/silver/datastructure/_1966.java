package jihun.algorithm.baekjoon.silver.datastructure;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 프린터 큐 - 우선순위 큐
 */
public class _1966 {

    @AllArgsConstructor
    static class Printer {
        int index;
        int priority;
    }

    static class PrinterComparator implements Comparator<Printer> {
        @Override
        public int compare(Printer o1, Printer o2) {
            // 우선순위가 동일한 경우 인덱스가 높은 게 먼저 나온다.
            if (o1.priority == o2.priority) {
                return o2.index - o1.index;
            }

            return o2.priority - o1.priority;
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        // 클래스 객체에 대한 우선순위 기준 제공
        final PriorityQueue<Printer> pq = new PriorityQueue<>(100, new PrinterComparator());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            // 큐 원소 삽입
            for (int i = 0; i < n; i++) {
                pq.offer(new Printer(0, Integer.parseInt(st.nextToken())));
            }

            // TODO 작업중
            for (int i = 1; i <= n; i++) {
                if (pq.poll().index == m) {
                    sb.append(i).append("\n");
                    break;
                }
            }

            pq.clear();
        }

        System.out.println(sb);
        br.close();
    }
}
