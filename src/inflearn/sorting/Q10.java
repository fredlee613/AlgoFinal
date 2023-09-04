package inflearn.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 10. 마구간 정하기(결정알고리즘)
 */
public class Q10 {

    public String locateHorses(int n, int s, int[] arr) {
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];
        int answer = 0;
        while (lt <= rt) {
            int tmp = (lt + rt) / 2;
            int cnt = calDistance(tmp, arr);
            if (cnt >= s) {
                answer = tmp;
                lt = tmp + 1;
            } else {
                rt = tmp - 1;
            }
        }
        return String.valueOf(answer);
    }

    private static int calDistance(int expected, int[] arr) {
        int cnt = 1, ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= expected) {
                ep = arr[i];
                cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {
        Q10 main = new Q10();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.locateHorses(n, m, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
