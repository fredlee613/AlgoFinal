package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 11. 임시반장 정하기
 */
public class Q11 {

    public String selectCaptain(int n, int[][] arr) {
        int biggest = 0;
        int answer = 1;
        for (int x = 0; x < n; x++) {
            int count = 0;
            for (int y = 0; y < n; y++) {
                if (y != x) {
                    if (haveWeMetBefore(arr[x], arr[y])) count++;
                }
            }
            if (count > biggest) {
                biggest = count;
                answer = x + 1;
            }
        }
        return String.valueOf(answer);
    }

    private static boolean haveWeMetBefore(int[] arr1, int[] arr2) {
        for (int i = 0; i < 5; i++) {
            if (arr1[i] == arr2[i]) return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        Q11 main = new Q11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[][] arr = new int[n][5];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < 5; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        stdOut.write(main.selectCaptain(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
