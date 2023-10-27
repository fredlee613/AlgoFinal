package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] board = new int[8][8];


    static int BFS(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cp = q.poll();
                if (cp.x == 7 && cp.y == 7) {
                    return answer;
                } else {
                    for (int j = 0; j < 4; j++) {
                        int nx = cp.x + dx[j];
                        int ny = cp.y + dy[j];
                        if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                            board[nx][ny] = 1;
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        board[1][1] = 1;
        answer = BFS(new Point(1, 1));

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
