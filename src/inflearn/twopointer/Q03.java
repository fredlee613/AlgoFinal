package inflearn.twopointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 최대 매출
 */
public class Q03 {
    public String findMaxSales(int n, int k, int[] arr) {
        int answer = 0;
        for (int i = 0; i < k; i++) answer += arr[i];
        int sum = answer;

        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stdOut.write(main.findMaxSales(n, k, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
