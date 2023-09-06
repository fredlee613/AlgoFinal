package inflearn.recursiveadvance;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 13. 섬나라 아일랜드
 */
public class Q13 {
    static int[][] board, dis;
    static int[] dx = {-1,-1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public void BFS() {
        while (!q.isEmpty()) {
            Point cp = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q13 main = new Q13();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(stdIn.readLine());
        board = new int[n][n];
        dis = new int[n][n];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < n; y++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[x][y] = tmp;
            }
        }

        int answer = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 1) {
                    q.offer(new Point(x, y));
                    main.BFS();
                    answer++;
                }
            }
        }

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
