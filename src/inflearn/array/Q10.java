package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 10. 봉우리
 */
public class Q10 {
    static int[] dx = {0, -1, 0, 1}; // 좌상우하
    static int[] dy = {-1, 0, 1, 0};


    public String countMounts(int n, int[][] arr) {
        int answer = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                boolean flag = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (arr[x][y] <= arr[nx][ny]) flag = false;
                    }
                }
                if (flag) answer++;
            }
        }

        return String.valueOf(answer);
    }


    public static void main(String[] args) throws IOException {
        Q10 main = new Q10();
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

        stdOut.write(main.countMounts(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
