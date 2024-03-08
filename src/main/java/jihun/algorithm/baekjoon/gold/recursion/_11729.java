package jihun.algorithm.baekjoon.gold.recursion;

import java.io.*;

/**
 * 하노이 탑 TODO RETRY
 */
public class _11729 {

    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        sb.append((int) Math.pow(2, n) - 1).append("\n");

        // 1번 기둥에서 3번 기둥으로 원판을 옮긴다.
        hanoi(n, 1, 3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void hanoi(int n, int x, int y) {
        // 1 -> 2
        if(n > 1)
            hanoi(n - 1, x, 6 - x - y);

        sb.append(x)
                .append(" ")
                .append(y)
                .append("\n");

        // 2 -> 3
        if(n > 1)
            hanoi(n - 1, 6 - x - y, y);
    }
}
