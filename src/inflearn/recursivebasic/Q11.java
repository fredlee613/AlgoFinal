package inflearn.recursivebasic;

import java.io.*;
import java.util.*;

/**
 * 11. 그래프 최단거리(BFS)
 */
public class Q11 {
    static int n, m;
    static int[] ch, dis;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int x = 0; x < size; x++) {
                Integer cp = q.poll();
                for (Integer nv : graph.get(cp)) {
                    if (ch[nv] != 1) {
                        ch[nv] = 1;
                        dis[nv] = dis[cp] + 1;
                        q.offer(nv);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q11 main = new Q11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        n = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        dis = new int[n + 1];
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        ch[1] = 1;
        dis[1] = 0;
        main.BFS(1);


        stdOut.write(Arrays.toString(dis));
        stdOut.flush();
        stdOut.close();
        stdIn.close();

    }
}
