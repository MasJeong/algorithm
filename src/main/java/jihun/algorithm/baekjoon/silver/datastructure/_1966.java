package jihun.algorithm.baekjoon.silver.datastructure;

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

    private static class Printer {
        int index;
        int priority;

        public Printer(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    private static class PrinterComparator implements Comparator<Printer> {
        @Override
        public int compare(Printer o1, Printer o2) {
            /*
            o1 - o2 > 0
            비교는 첫 번째 인자를 기준으로
            위처럼 양수의 경우 o1이 뒤로 감
            음수의 경우 o1이 앞으로 감
             */
            if (o1.priority > o2.priority) {
                return -1;
            } else if (o1.priority < o2.priority) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        final PriorityQueue<Printer> pq = new PriorityQueue<>(100, new PrinterComparator());
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            // 큐 원소 삽입
            for (int i = 0; i < n; i++) {
                pq.offer(new Printer(i, Integer.parseInt(st.nextToken())));
            }

            for (int i = 1; i <= n; i++) {
                if (pq.poll().index == m) {
                    sb.append(i).append("\n");
                    break;
                }
            }

            // 우선순위 큐 초기화
            pq.clear();
        }

        System.out.println(sb);
        br.close();
    }
}
