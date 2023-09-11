package inflearn.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 5. 다익스트라 알고리즘
 */
public class Q05 {
    static int n, m;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    static class Edge implements Comparable<Edge> {
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

        @Override
        public String toString() {
            return "(" + vertex + ", " + cost + ")";
        }
    }

    public void findShortestPath(int v) {
        dis[v] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(v, 0));
        while (!q.isEmpty()) {
//            System.out.println("q = " + q.toString());
            Edge ce = q.poll();
            int cv = ce.vertex;
            int cc = ce.cost;
            if (dis[cv] < cc) continue;
            for (Edge edge : graph.get(cv)) {
//                System.out.println("edge = " + edge);
                if (dis[edge.vertex] > cc + edge.cost) {
                    dis[edge.vertex] = cc + edge.cost;
                    q.offer(new Edge(edge.vertex, cc + edge.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        main.findShortestPath(1);
//        System.out.println("dis = " + Arrays.toString(dis));
        for (int i = 2; i <= n; i++) {
            String tmp = i + " : ";
            if (dis[i] == Integer.MAX_VALUE) tmp += "impossible";
            else tmp += dis[i];
            if (i != n) tmp += "\n";

            stdOut.write(tmp);
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
