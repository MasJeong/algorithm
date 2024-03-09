package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 풍선 터뜨리기 - 스택 큐 덱
 * 큐를 좌우로 움직이는 것보다 입력값과 입력값의 인덱스를
 * 저장해둘 곳 생각을 깊게 못해 애를 먹었다.
 */
public class _2346 {

    static class NumAndValue {
        int value;
        int index;

        public NumAndValue(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<NumAndValue> deque = new ArrayDeque<>();

        sb.append(1).append(" ");
        int num = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            deque.offerLast(new NumAndValue(Integer.parseInt(st.nextToken()), i + 1));
        }

        /*
        3 2 1 -3 -1
        1 4 5 3 2
        2 2 2 2
        1 3 2 4
         */
        for (int i = 1; i < n; i++) {
            if (num > 0) {
                int temp = num;
                while (temp-- > 1 && !deque.isEmpty()) {
                    deque.offerLast(deque.pollFirst());
                }

                NumAndValue numAndValue = deque.pollFirst();
                num = numAndValue.value;
                sb.append(numAndValue.index).append(" ");
            } else {
                int temp = num;
                while (temp++ < -1 && !deque.isEmpty()) {
                    deque.offerFirst(deque.pollLast());
                }

                NumAndValue numAndValue = deque.pollLast();
                num = numAndValue.value;
                sb.append(numAndValue.index).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
