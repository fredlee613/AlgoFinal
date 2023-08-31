package inflearn.twopointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2. 공통원소 구하기
 */
public class Q02 {
    public String mergeArrays(int n, int m, int[] nArr, int[] mArr) {
        Arrays.sort(nArr);
        Arrays.sort(mArr);
        String answer = "";
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx < m && nArr[i] >= mArr[idx]) {
                if (nArr[i] == mArr[idx]) {
                    answer += nArr[i] + " ";
                }
                idx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
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

