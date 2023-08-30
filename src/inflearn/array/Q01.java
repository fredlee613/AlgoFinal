package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 큰 수 출력하기
 */
public class Q01 {
    public String printBiggerInt(int n, int[] arr) {
        String answer = String.valueOf(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) answer += " " + arr[i];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.printBiggerInt(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
