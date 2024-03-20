package jihun.algorithm.baekjoon.silver.datastructure;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프린터 큐 - TODO 작업중
 */
public class _1966 {

    @AllArgsConstructor
    static class Printer {
        int a;
    }

    // 클래스 객체의 우선순위를 위한 클래스
    static class PrinterComparator implements Comparator<Printer> {
        @Override
        public int compare(Printer o1, Printer o2) {
            if (o1.a == o2.a) {
                return o2.a - o1.a;
            } else {
                return o1.a - o2.a;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 클래스 객체에 대한 우선순위 기준 제공
        final PriorityQueue<Printer> priorityQueue = new PriorityQueue<>(100, new PrinterComparator());

        int n = Integer.parseInt(br.readLine());
        

        priorityQueue.offer(new Printer(1));
    }
}
