package jihun.algorithm.baekjoon.gold.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위 표기식 - 자료구조
 */
public class _1918_retry {

    /**
     * 연산자 우선순위를 반환한다.
     * @param ch 연산자
     * @return 우선순위 0(낮음) ~ 2(높음)
     */
    static int priority(char ch) {
        if(ch == '(' || ch == ')') return 0;

        if(ch == '+' || ch == '-') return 1;

        if(ch == '*' || ch == '/') return 2;

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);

            switch (input) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(input)) {
                        sb.append(stack.pop());
                    }
                    stack.push(input);
                    break;
                case '(':
                    stack.push(input);
                    break;
                case ')':
                    /*
                    ( 괄호가 나오기 전까지 존재하는 연산자를 출력한다.
                    () 괄호 사이에 있는 연산자는 우선순위가 높은 연산자이기 때문에
                    연산자가 출력문 앞쪽에 위치한다.
                     */
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    // push 했던 ( 괄호를 제거한다.
                    stack.pop();
                    break;
                default :
                    sb.append(input);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }
}
