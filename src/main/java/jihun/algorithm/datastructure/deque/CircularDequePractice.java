package jihun.algorithm.datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularDequePractice {

    private static int[] queue = new int[8];

    // 첫 번째 인덱스는 빈 공간
    private static int front = 0;
    private static int rear = 0;
    private static int size = 0;

    private static void resizeQueue(int newLength) {
        int[] newQueue = new int[newLength];

        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newQueue[i] = queue[j % queue.length];
        }

        queue = newQueue;
        front = 0;

        /*
        용량이 더 커진 경우에는 1자로 데이터가 나열되었기 때문에 rear = size
        용량이 더 작아진 경우에는 데이터가 없어서 사이즈를 줄인 것.
         */
        rear = size;
    }

    private static void offerFirst(int val) {
        // 원소가 가득찬 경우 배열 동적 길이 조정
        if (rear == (front - 1 + queue.length) % queue.length) {
            resizeQueue(queue.length * 2);
        }

        queue[front] = val;
        front = (front - 1 + queue.length) % queue.length;

        // front는 빈공간으로 유지한다.
        queue[front] = 0;
        size++;
    }

    private static void offerLast(int val) {
        // 원소가 가득찬 경우 배열 동적 길이 조정
        if (front == (rear + 1) % queue.length) {
            resizeQueue(queue.length * 2);
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = val;
        size++;
    }

    private static int pollFirst() {
        if (size <= 0) return -1;

        front = (front + 1) % queue.length;
        int ele = queue[front];

        // front 0으로 유지.
        queue[front] = 0;
        size--;

        return ele;
    }

    private static int pollLast() {
        if (size <= 0) return -1;

        int ele = queue[rear];
        queue[rear] = 0;

        rear = (rear - 1 + queue.length) % queue.length;
        size--;
        return ele;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];

        offerFirst(1);
        offerLast(2);
        offerFirst(-1);
        offerFirst(-5);

        pollFirst();
        pollLast();
        pollLast();
        pollFirst();

        br.close();
    }
}
