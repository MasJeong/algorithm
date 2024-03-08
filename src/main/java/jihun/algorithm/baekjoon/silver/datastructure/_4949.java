package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 균형잡힌세상 - 스택 큐 덱
 */
public class _4949 {

    private static char[] stack;

    private static int pointer = -1;

    private static int size = 0;

    private static void push(char val) {
        stack[++pointer] = val;
        size++;
    }

    private static char pop() {
        if (size == 0) {
            return '\0';
        }

        size--;
        return stack[pointer--];
    }

    private static boolean isEmpty() {
        return size == 0;
    }

    private static void initStack(int resize) {
        size = 0;
        pointer = -1;
        stack = new char[resize];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while ((str = br.readLine()) != null && !str.isEmpty() && !".".equals(str)) {
            // 스택 초기화
            initStack(str.length());

            boolean isError = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[') {
                    push(ch);
                } else if (ch == ')') {
                    char popData = pop();

                    // pop 실패 시
                    if(popData != '(') {
                        isError = true;
                        break;
                    }
                } else if (ch == ']') {
                    char popData = pop();

                    // pop 실패 시
                    if(popData != '[') {
                        isError = true;
                        break;
                    }
                }
            }

            if (isEmpty() && !isError) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

        }

        System.out.println(sb);
        br.close();
    }
}
