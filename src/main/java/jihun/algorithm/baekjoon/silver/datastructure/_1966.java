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
        int pointer;
        int priority;
    }

    // 클래스 객체의 우선순위를 위한 클래스
    static class PrinterComparator implements Comparator<Printer> {
        @Override
        public int compare(Printer o1, Printer o2) {
            if (o1.priority != o2.priority) {
                return o2.priority - o1.priority;
            }

            return 0;
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

            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());

                if (m == i) {
                    pq.offer(new Printer(m, priority));
                } else {
                    pq.offer(new Printer(0, priority));
                }
            }

            for (int i = 1; i <= n; i++) {
                Printer printer = pq.poll();

                // TODO 작업중
                if (printer.pointer == m) {
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
