package jihun.algorithm.baekjoon.silver.etc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0.0;
        double sumGrade = 0.0;
        String[] arrInput = null;

        for(int i = 0; i < 20; i++) {
            arrInput = br.readLine().split(" ");

            if(!"P".equals(arrInput[2])) {
                sum += Double.parseDouble(arrInput[1]) * score(arrInput[2]);
                sumGrade += Double.parseDouble(arrInput[1]);
            }
        }

        System.out.printf("%.6f", sum / sumGrade);

        br.close();
    }
    private static double score(String grade) {
        double rtn = 0.0;

        switch(grade) {
            case "A+":
                rtn = 4.5;
                break;
            case "A0":
                rtn = 4.0;
                break;
            case "B+":
                rtn = 3.5;
                break;
            case "B0":
                rtn = 3.0;
                break;
            case "C+":
                rtn = 2.5;
                break;
            case "C0":
                rtn = 2.0;
                break;
            case "D+":
                rtn = 1.5;
                break;
            case "D0":
                rtn = 1.0;
                break;
            case "F":
                rtn = 0.0;
                break;
            default:
                break;
        }

        return rtn;
    }
}
