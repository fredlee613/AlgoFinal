package boj.greedy.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1916 {
    static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    static int n, m;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static int Dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentCost = currentEdge.cost;
            int currentVertex = currentEdge.vertex;
            if (dist[currentVertex] < currentCost) continue;
            for (Edge edge : graph.get(currentVertex)) {
                int nextVertex = edge.vertex;
                int nextCost = edge.cost;
                if (dist[nextVertex] > currentCost + nextCost) {
                    dist[nextVertex] = currentCost + nextCost;
                    pq.offer(new Edge(nextVertex, currentCost + nextCost));
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(stdIn.readLine());
        m = Integer.parseInt(stdIn.readLine());
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }
        st = new StringTokenizer(stdIn.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        stdOut.write(String.valueOf(Dijkstra(start, end)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
