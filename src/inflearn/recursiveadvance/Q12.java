package inflearn.recursiveadvance;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 12. 토마토(BFS 활용)
 */
public class Q12 {
    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int n, m;
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
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[cp.x][cp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q12 main = new Q12();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new int[n][m];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < m; y++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) q.offer(new Point(x, y));
                board[x][y] = tmp;
            }
        }

        main.BFS();

        boolean flag = true;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] == 0) flag = false;
            }
        }
        int answer = Integer.MIN_VALUE;
        if (flag) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    answer = Math.max(answer, dis[x][y]);
                }
            }
            stdOut.write(String.valueOf(answer));
        } else {
            stdOut.write(String.valueOf(-1));
        }

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
