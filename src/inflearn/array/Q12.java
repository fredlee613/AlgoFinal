package inflearn.array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 12. 멘토링
 */
public class Q12 {

    public String matchingMentor(int n, int m, int[][] arr) {
        int[][] tmp = new int[m][n];
        int answer = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int num = arr[x][y] - 1;
                tmp[num][x] = y + 1;
            }
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < m; y++) {
                if (x != y) {
                    if (canBeMentor(n, tmp[x], tmp[y])) answer++;
                }
            }
        }

        return String.valueOf(answer);
    }

    private static boolean canBeMentor(int n, int[] arr1, int[] arr2) {
        for (int i = 0; i < n; i++) {
            if (arr1[i] > arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Q12 main = new Q12();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        // 학생 수: m, 시험 횟수: n
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < m; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        stdOut.write(main.matchingMentor(n, m, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
