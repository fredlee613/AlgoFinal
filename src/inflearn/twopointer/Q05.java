package inflearn.twopointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 5. 연속된 자연수의 합
 */
public class Q05 {
    public String findSumOfContinueNum(int n) {
        int[] arr = new int[n + 1];
        int answer = 0, sum = 0, lt = 0;
        int num = n / 2 + 1;
        for (int i = 1; i <= num; i++) arr[i] = i;
        for (int rt = 1; rt <= num; rt++) {
            sum += arr[rt];
            if (sum == n) answer++;
            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());

        stdOut.write(main.findSumOfContinueNum(n));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
