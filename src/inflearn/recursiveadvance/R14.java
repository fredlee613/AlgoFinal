package inflearn.recursiveadvance;

import java.io.*;
import java.util.*;

/**
 * 14. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
 */
public class R14 {
    static int n, m, answer = Integer.MAX_VALUE;
    static ArrayList<Point> houses, stores;
    static Point[] candidates;
    static int[][] board;

    static class Point {
        int x;
        int y;

        public Point() {}

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        R14 main = new R14();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        candidates = new Point[m];
        houses = new ArrayList<>();
        stores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < n; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) houses.add(new Point(i, j));
                if (type == 2) stores.add(new Point(i, j));
                board[i][j] = type;
            }
        }

        main.DFS(0, 0);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    public void DFS(int L, int S) {
        if (L == m) {
            int sum = 0;
            for (Point house : houses) {
                int tmp = Integer.MAX_VALUE;
                for (Point store : candidates) {
                    int dis = (Math.abs(house.x - store.x) + Math.abs(house.y - store.y));
                    tmp = Math.min(tmp, dis);
                }
                sum += tmp;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = S; i < stores.size(); i++) {
                candidates[L] = stores.get(i);
                DFS(L + 1, i + 1);
            }
//            System.out.println("candidates = " + Arrays.toString(candidates));
        }
    }

}
