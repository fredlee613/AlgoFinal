package inflearn.recursiveadvance;

import java.io.*;
import java.util.*;

/**
 * 14. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
 */
public class Q14 {
    static int[][] board, ch;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static Point[] pizzaStoreToClose;
    static int n, m, cnt = 0, numOfPizzaStore = 0, answer = Integer.MAX_VALUE;
    static Queue<Point> q = new LinkedList<>();
    static ArrayList<Point> allPizzaStore = new ArrayList<>();

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

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }
    }

    static void closePizzaStores(Point[] stores) {
//        System.out.println("cnt = " + cnt + ", closing stores:(");
        for (Point store : stores) {
            if (board[store.x][store.y] == 2) board[store.x][store.y] = 3;
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
//                System.out.print(board[x][y] + " ");
            }
//            System.out.println();
        }

    }

    public int calDistance(int x, int y, int[][] ch) {
        boolean flag = false;
        int result = Integer.MAX_VALUE;
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point cp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] != 1) {
                    ch[nx][ny] = 1;
                    if (board[nx][ny] == 2) {
                        result = Math.min(result, (Math.abs(x - nx) + Math.abs(y - ny)));
//                        System.out.println("result = " + result);
                    }
                    q.offer(new Point(nx, ny));
                }
            }
//            System.out.println("q = " + q);
        }
        return result;
    }

    public void pickPizzaStoreToShutDown(int L, int S) {
        if (L == numOfPizzaStore - m) {
            cnt++;
//            System.out.println("pizzaStoreToClose = " + Arrays.toString(pizzaStoreToClose));
            closePizzaStores(pizzaStoreToClose);

            int tmp = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (board[x][y] == 1) {
                        int[][] chTmp = new int[n][n];
                        chTmp[x][y] = 1;
                        int tmp1 = calDistance(x, y, chTmp);
//                        System.out.print(tmp1 + " ");
                        tmp += tmp1;
                    }
                }
            }
//            System.out.println("answer = " + answer + ", tmp = " + tmp);
            answer = Math.min(answer, tmp);
            restore();

        } else {
            for (int i = S; i < numOfPizzaStore; i++) {
                pizzaStoreToClose[L] = allPizzaStore.get(i);
                pickPizzaStoreToShutDown(L + 1, i + 1);
            }
        }
    }

    private static void restore() {
//        System.out.println("cnt = " + cnt + ", restoring stores:)");
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 3) board[x][y] = 2;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Q14 main = new Q14();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;
                if (tmp == 2) {
                    allPizzaStore.add(new Point(i, j));
                    numOfPizzaStore++;
                }
            }
        }
        pizzaStoreToClose = new Point[numOfPizzaStore - m];


//        System.out.println("n = " + n + ", m = " + m + ", numOfPizzaStore = " + numOfPizzaStore);
//        System.out.println("list.toString() = " + allPizzaStore.toString());
        main.pickPizzaStoreToShutDown(0, 0);
//        System.out.println("cnt = " + cnt);
//        System.out.println("answer = " + answer);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
