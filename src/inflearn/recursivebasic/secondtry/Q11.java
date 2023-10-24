package inflearn.recursivebasic.secondtry;

import java.io.*;
import java.util.*;

public class Q11 {
    static int n, m;
    static int[] dist = new int[n + 1];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void BFS(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cv = q.poll();
                for (Integer nv : graph.get(cv)) {
                    if (dist[cv] + 1 < dist[nv]) {
                        dist[nv] = dist[cv] + 1;
                        q.offer(nv);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        for (int i = 2; i <= n; i++) dist[i] = Integer.MAX_VALUE;

        dist[1] = 0;

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.print(i + " : " + dist[i]);
            if (i != n) System.out.println();
        }
    }
}
