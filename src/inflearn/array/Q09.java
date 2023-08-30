package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 9. 격자판 최대합
 */
public class Q09 {
    public String calculateRanking(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;

        // 가로
        for (int x = 0; x < n; x++) {
            int tmp = 0;
            for (int y = 0; y < n; y++) {
                tmp += arr[x][y];
            }
            answer = Math.max(answer, tmp);
        }

        // 세로

        for (int x = 0; x < n; x++) {
            int tmp = 0;
            for (int y = 0; y < n; y++) {
                tmp += arr[y][x];
            }
            answer = Math.max(answer, tmp);
        }

        // 대각
        int sumA = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x == y) sumA += arr[x][y];
            }
        }
        int sumB = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x + y == 4) sumB += arr[x][y];
            }
        }
        answer = Math.max(answer, Math.max(sumA, sumB));

        return String.valueOf(answer);
    }


    public static void main(String[] args) throws IOException {
        Q09 main = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[][] arr = new int[n][n];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < n; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        stdOut.write(main.calculateRanking(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
