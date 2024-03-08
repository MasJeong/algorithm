package jihun.algorithm.baekjoon.bronze.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 단어 뒤집기 - 자료구조
 * - 스택으로 풀자
 */
public class _9093 {
    private static int pointer = -1;
    private static int size = 0;

    private static void push(char[] stack, char val) {
        stack[++pointer] = val;
        size++;
    }

    private static char pop(char[] stack) {
        size--;
        return stack[pointer--];
    }

    private static boolean empty() {
        return size <= 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        char[] stack = new char[1000];

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String str = st.nextToken();

                for(int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);

                    push(stack, ch);
                }

                while(!empty()) {
                    sb.append(pop(stack));
                }

                sb.append(" ");
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
