package inflearn.recursiveadvance;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 10. 미로탐색(DFS)
 */
public class Q10 {
    static int[][] board = new int[8][8];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int answer = 0;

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q10 main = new Q10();
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
        main.DFS(1, 1);
        stdOut.write(String.valueOf(answer));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
