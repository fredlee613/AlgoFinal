package inflearn.greedy.firsttry;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
 */
public class R05 {
    static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;
        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> list = new ArrayList<>();

    public void findShortestPath(int v) {
        dis[v] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        while (!pq.isEmpty()) {
            Edge ce = pq.poll();
            int cv = ce.vertex;
            int cc = ce.cost;
            if (dis[cv] < cc) continue;
            for (Edge edge : list.get(cv)) {
                if (dis[edge.vertex] > cc + edge.cost) {
                    dis[edge.vertex] = cc + edge.cost;
                    pq.offer(new Edge(edge.vertex, edge.cost + cc));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        R05 main = new R05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        main.findShortestPath(1);
        for (int i = 2; i <= n; i++) {
            String tmp = i + " : ";
            if (dis[i] != Integer.MAX_VALUE) tmp += dis[i];
            else tmp += "impossible";

            if (i != n) tmp += "\n";
            stdOut.write(tmp);
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
