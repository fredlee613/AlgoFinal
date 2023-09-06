package inflearn.recursiveadvance;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 11. 미로의 최단거리 통로(BFS)
 */
public class Q11 {
    static int[][] board = new int[8][8], dis = new int[8][8];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point cp = q.poll();
            for (int j = 0; j < 4; j++) {
                int nx = cp.x + dx[j];
                int ny = cp.y + dy[j];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[cp.x][cp.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Q11 main = new Q11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        board[1][1] = 1;
        main.BFS(1, 1);
        if (dis[7][7] == 0) stdOut.write(String.valueOf(-1));
        else stdOut.write(String.valueOf(dis[7][7]));


        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
