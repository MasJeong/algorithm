package jihun.algorithm.baekjoon.gold.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오등큰수 - 자료구조
 */
public class _17299_fail_timeout {

    private static int[] stack;
    private static int pointer = -1;
    private static int size = 0;

    private static void push(int val) {
        stack[++pointer] = val;
        size++;
    }

    private static void setStackSize(int length) {
        stack = new int[length];
    }

    private static int pop() {
        if(pointer < 0) {
            return -1;
        }

        size--;
        return stack[pointer--];
    }

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final int COUNTING_MAX_SIZE = 1000001;

        int n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 원본배열 (1 1 2 3 4 2 1)
        int[] arrOriginal = new int[n];
        // 중간과정 배열 (3 3 2 1 1 2 3)
        int[] arrTemp = new int[n];
        // 카운팅 배열
        int[] arrCounting = new int[COUNTING_MAX_SIZE];

        // 스택 사이즈 세팅
        setStackSize(n);
        
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());

            // 카운팅 배열 세팅
            arrCounting[input] += 1;

            // 원본 배열 세팅
            arrOriginal[i - 1] = input;
        }

        /*
         * 1 1 2 3 4 2 1
         * 3 3 2 1 1 2 3 - 만드는 과정
         * -1 -1 1 2 2 1 -1
         */
        for (int i = 0; i < n; i++) {
            arrTemp[i] = arrCounting[arrOriginal[i]];
            push(arrTemp[i]);
        }

        int[] arrResult = new int[n];

        int startIdx = size;

        for (int i = startIdx - 1; i >= 0; i--) {
            int num = pop();

            boolean isFind = false;
            for(int j = i + 1; j < n; j++) {
                if (arrTemp[j] > num) {
                    isFind = true;
                    arrResult[i] = arrOriginal[j];
                    break;
                }
            }

            // 못찾은 경우
            if (!isFind) {
                arrResult[i] = -1;
            }
        }

        for (int i = 0; i < arrResult.length - 1; i++) {
            sb.append(arrResult[i]).append(" ");
        }
        sb.append(arrResult[arrResult.length - 1]);

        System.out.println(sb);
        br.close();
    }
}
