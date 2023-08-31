package inflearn.twopointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 6. 최대 길이 연속부분수열
 */
public class Q06 {
    public String findMaxLengthOfSubsequences(int n, int k, int[] arr) {
        int answer = 0, lt = 0, cnt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;
            while (cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
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

        stdOut.write(main.findMaxLengthOfSubsequences(n, k, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
