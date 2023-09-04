package inflearn.recursivebasic;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 8. 송아지 찾기 1(BFS : 상태트리탐색)
 */
public class Q08 {
    static int s, e;
    static int[] dx = {1, -1, 5};
    public int BFS() {
        int cnt = 0;
        int[] ch = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        ch[s] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cq = queue.poll();
                if (cq == e) return cnt;
                else {
                    for (int j = 0; j < dx.length; j++) {
                        int nx = cq + dx[j];
                        if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                            ch[nx] = 1;
                            queue.offer(nx);
                        }
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        stdOut.write(String.valueOf(main.BFS()));

        stdOut.flush();
        stdOut.close();
        stdIn.close();

    }
}
