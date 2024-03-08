package jihun.algorithm.baekjoon.bronze.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());

        if(num1 + num2 + num3 == 180) {
            if(num1 == num2 && num2 == num3)
                System.out.println("Equilateral");
            else if(num1 == num2 || num1 == num3 || num2 == num3) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }

        br.close();
    }
}
