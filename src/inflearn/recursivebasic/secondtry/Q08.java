package inflearn.recursivebasic.secondtry;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q08 {
    static int n, m;
    static int[] arr = new int[10001], dir = {1, -1, 5};
    static Queue<Integer> q = new LinkedList<>();

    static int BFS(Integer n) {
        q.offer(n);
        arr[n] = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cp = q.poll();
                if (cp == m) return cnt;
                for (int j = 0; j < 3; j++) {
                    int np = cp + dir[j];
                    if (arr[np] == 0 & np >= 1 & np <= 10000) {
                        arr[np] = 1;
                        q.offer(np);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        stdOut.write(String.valueOf(BFS(n)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
