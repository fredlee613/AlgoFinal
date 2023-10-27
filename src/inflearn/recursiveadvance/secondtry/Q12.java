package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, answer = 0;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] board;
    static Queue<Point> q = new LinkedList<>();

    static int BFS() {
        if (isRiped()) return 0;
        while (!q.isEmpty()) {
            if (isRiped()) return answer;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cp.x + dx[j];
                    int ny = cp.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    static boolean isRiped() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) q.offer(new Point(i, j));
                board[i][j] = tmp;
            }
        }
        stdOut.write(String.valueOf(BFS()));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
