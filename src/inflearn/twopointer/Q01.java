package inflearn.twopointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 두 배열 합치기
 */
public class Q01 {
    public String mergeArrays(int n, int m, int[] nArr, int[] mArr) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx < m && nArr[i] > mArr[idx]) {
                answer += mArr[idx] + " ";
                idx++;
            }
            answer += nArr[i] + " ";
        }
        if (idx < m) {
            for (int i = idx; i < m; i++) {
                answer += mArr[i] + " ";
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] nArr = new int[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(stdIn.readLine());
        int[] mArr = new int[m];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        stdOut.write(main.mergeArrays(n, m, nArr, mArr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
