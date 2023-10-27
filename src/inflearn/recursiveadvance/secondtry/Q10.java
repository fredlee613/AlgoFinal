package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q10 {
    static int answer = 0;
    static int[] dirX = {0, 1, 0, -1}, dirY = {1, 0, -1, 0};
    static int[][] maze = new int[7][7];


    static void DFS(int x, int y) {
        if (x == 6 & y == 6) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    DFS(nx, ny);
                    maze[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < 7; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maze[0][0] = 1;
        DFS(0, 0);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
