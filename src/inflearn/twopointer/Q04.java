package inflearn.twopointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. 연속 부분수열
 */
public class Q04 {
    public String findSubsequences(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stdOut.write(main.findSubsequences(n, m, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
