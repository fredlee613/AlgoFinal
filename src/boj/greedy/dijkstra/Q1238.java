package boj.greedy.dijkstra;

import java.io.*;
import java.util.*;

public class Q1238 {
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
    static int N, M, X;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static int[] Dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
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
        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }
        int answer = Integer.MIN_VALUE;
        int[] wayBackHome = Arrays.stream(Dijkstra(X)).toArray();
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, Dijkstra(i)[X] + wayBackHome[i]);
        }

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
