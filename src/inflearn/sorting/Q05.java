package inflearn.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 5. 중복 확인
 */
public class Q05 {

    public String isDuplicated(int n, int[] arr) {
        Arrays.sort(arr);
        for (int x = 0; x < n - 1; x++) {
            if (arr[x] == arr[x + 1]) return "D";
        }
        return "U";
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.isDuplicated(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
