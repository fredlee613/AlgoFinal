package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[ x = " + x + ", y = " + y + " ]";
        }
    }

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] board;
    static Point[] stores;
    static ArrayList<Point> pizzaStores = new ArrayList<>();

    static int calDist() {
        int dist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    int tmp = Integer.MAX_VALUE;
                    for (Point store : stores) {
                        tmp = Math.min(tmp, Math.abs(i - store.x) + Math.abs(j - store.y));
                    }
                    dist += tmp;
                }
            }
        }
        return dist;
    }

    static void DFS(int L, int S) {
        if (L == M) {
            // 각 조합 최소배달거리 합을 구한 후 비교하기
            answer = Math.min(answer, calDist());
        } else {
            // 피자 가게 조합
            for (int i = S; i < pizzaStores.size(); i++) {
                stores[L] = pizzaStores.get(i);
                DFS(L + 1, i + 1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        stores = new Point[M];

        // 피자 가게일 경우 배열에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) pizzaStores.add(new Point(i, j));
                board[i][j] = tmp;
            }
        }
        DFS(0, 0);
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
